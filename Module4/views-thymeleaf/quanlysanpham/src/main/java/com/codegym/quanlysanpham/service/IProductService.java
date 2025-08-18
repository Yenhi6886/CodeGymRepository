package com.codegym.quanlysanpham.service;

import com.codegym.quanlysanpham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(int id, Product product);

    void delete(int id);

    List<Product> searchByName(String name);
}

