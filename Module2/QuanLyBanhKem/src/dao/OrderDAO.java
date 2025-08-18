package dao;

import model.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAll();

    Order findById(String id);

    void add(Order o);

    void update(Order o);

    void delete(String id);

    void loadFromFile();

    void saveToFile();
}