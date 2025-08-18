package dao;

import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private List<Order> orders = new ArrayList<>();
    private final String filePath = "orders.txt";

    @Override
    public void loadFromFile() {
        orders.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                orders.add(Order.fromCSV(line));
            }
        } catch (IOException e) {
            // File chưa tồn tại
        }
    }

    @Override
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Order o : orders) {
                pw.println(o.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order findById(String id) {
        for (Order o : orders) if (o.getOrderId().equals(id)) return o;
        return null;
    }

    @Override
    public void add(Order o) {
        orders.add(o);
    }

    @Override
    public void update(Order o) {
        delete(o.getOrderId());
        orders.add(o);
    }

    @Override
    public void delete(String id) {
        orders.removeIf(o -> o.getOrderId().equals(id));
    }
}