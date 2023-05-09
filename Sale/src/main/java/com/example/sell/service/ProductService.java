package com.example.sell.service;

import com.example.sell.entity.Customer;
import com.example.sell.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void addProduct(Product product);

    public List<Product> findAll();

    public Optional<Product> findProductById(int id);

    public void deleteProduct(int id);

}
