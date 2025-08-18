package com.codegym.customer.repository;

import com.codegym.customer.model.Customer;

public interface ICustomerRepository {
    boolean saveWithStoredProcedure(Customer customer);
}