package com.example.sell.service.Impl;

import com.example.sell.entity.Cart;
import com.example.sell.repository.CartRepository;
import com.example.sell.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findCartById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void deleteCart(int id) {

    }
}
