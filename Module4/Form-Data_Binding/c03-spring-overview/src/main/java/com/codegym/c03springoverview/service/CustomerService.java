package com.codegym.c03springoverview.service;

import com.codegym.c03springoverview.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Ha Noi","img1"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Hai Phong","img2"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Sai Gon","img3"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijing","img4"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami","img5"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "NewYork", "img6"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}