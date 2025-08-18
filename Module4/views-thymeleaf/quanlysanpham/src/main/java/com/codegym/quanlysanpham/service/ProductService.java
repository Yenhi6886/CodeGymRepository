package com.codegym.quanlysanpham.service;

import com.codegym.quanlysanpham.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService  implements IProductService {

    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iPhone 14", 1000, "Flagship Apple", "Apple"));
        products.add(new Product(2, "Galaxy S23", 900, "Flagship Samsung", "Samsung"));
        products.add(new Product(3, "iPhone 8", 2000, "Flagship Apple", "Apple"));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }


    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                // Ensure the id is not changed
                product.setId(id);
                products.set(i, product);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
