package com.codegym.wbdscustomermanagementcontroller.service;

import com.codegym.wbdscustomermanagementcontroller.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}