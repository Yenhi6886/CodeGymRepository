package model;

public class Cake {
    private String id;
    private String name;
    private String type;
    private double price;
    private int quantity;
    private String description;

    public Cake() {
    }

    public Cake(String id, String name, String type, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toCSV() {
        return String.join(",",
                id, name, type,
                String.valueOf(price),
                String.valueOf(quantity),
                description.replace(",", ";")
        );
    }

    public static Cake fromCSV(String line) {
        String[] parts = line.split(",", 6);
        Cake c = new Cake();
        c.setId(parts[0]);
        c.setName(parts[1]);
        c.setType(parts[2]);
        c.setPrice(Double.parseDouble(parts[3]));
        c.setQuantity(Integer.parseInt(parts[4]));
        c.setDescription(parts[5].replace(";", ","));
        return c;
    }
}
