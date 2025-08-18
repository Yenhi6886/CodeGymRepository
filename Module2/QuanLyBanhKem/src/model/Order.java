package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
    public enum Status {UNCONFIRMED, SHIPPING, COMPLETED}

    private String orderId;
    private String customerName;
    private String phone;
    private String address;
    private Map<String, Integer> items = new HashMap<>(); // Map<CakeId, quantity>
    private double total;
    private LocalDateTime orderDate;
    private Status status;

    public Order() {
        this.orderDate = LocalDateTime.now();
        this.status = Status.UNCONFIRMED;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void calculateTotal(services.CakeService cakeService) {
        this.total = items.entrySet().stream()
                .mapToDouble(e -> {
                    model.Cake cake = cakeService.getCakeById(e.getKey());
                    return (cake != null ? cake.getPrice() * e.getValue() : 0);
                }).sum();
    }

    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(orderId).append(",")
                .append(customerName.replace(",", ";")).append(",")
                .append(phone).append(",")
                .append(address.replace(",", ";")).append(",");
        String itemsStr = items.entrySet().stream()
                .map(e -> e.getKey() + ":" + e.getValue())
                .reduce((s1, s2) -> s1 + ";" + s2).orElse("");
        sb.append(itemsStr).append(",")
                .append(total).append(",")
                .append(orderDate.toString()).append(",")
                .append(status.name());
        return sb.toString();
    }

    public static Order fromCSV(String line) {
        String[] parts = line.split(",", 8);
        Order o = new Order();
        o.setOrderId(parts[0]);
        o.setCustomerName(parts[1].replace(";", ","));
        o.setPhone(parts[2]);
        o.setAddress(parts[3].replace(";", ","));
        if (!parts[4].isEmpty()) {
            String[] itemArr = parts[4].split(";");
            for (String item : itemArr) {
                String[] kv = item.split(":");
                if (kv.length == 2) {
                    o.getItems().put(kv[0], Integer.parseInt(kv[1]));
                }
            }
        }
        o.total = Double.parseDouble(parts[5]);
        o.orderDate = LocalDateTime.parse(parts[6]);
        o.status = Status.valueOf(parts[7]);
        return o;
    }
}