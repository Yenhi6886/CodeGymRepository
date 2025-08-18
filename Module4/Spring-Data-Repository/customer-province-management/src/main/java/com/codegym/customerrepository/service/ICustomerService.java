package com.codegym.customerrepository.service;

import com.codegym.customerrepository.model.Customer;
import com.codegym.customerrepository.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
}