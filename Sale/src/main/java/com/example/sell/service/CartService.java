package com.example.sell.service;

import com.example.sell.entity.Cart;
import com.example.sell.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CartService {

    public void addCart(Cart cart);

    public List<Cart> findAll();

    Optional<Cart> findCartById(int id);

    public void deleteCart(int id);
}
