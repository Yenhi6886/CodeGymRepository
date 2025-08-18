package services;

import dao.OrderDAO;
import model.Order;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;
    private CakeService cakeService;

    public OrderService(OrderDAO dao, CakeService cakeService) {
        this.orderDAO = dao;
        this.cakeService = cakeService;
        dao.loadFromFile();
    }

    public void placeOrder(Order o) {
        o.calculateTotal(cakeService);
        orderDAO.add(o);
        orderDAO.saveToFile();
    }

    public void updateStatus(String id, Order.Status st) {
        Order o = orderDAO.findById(id);
        if (o != null) {
            o.setStatus(st);
            orderDAO.update(o);
            orderDAO.saveToFile();
        }
    }

    public List<Order> listAll() {
        return orderDAO.getAll();
    }

    public Order findById(String id) {
        return orderDAO.findById(id);
    }
}