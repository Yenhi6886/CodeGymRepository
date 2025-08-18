package com.codegym.customer.service;

import com.codegym.customer.model.Customer;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
}
