package com.example.sell.controller;

import com.example.sell.entity.Cart;
import com.example.sell.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController{

    @Autowired
    private CartService cartService;

    @GetMapping("/findAll")
    public List<Cart> findAll(){
        return cartService.findAll();
    }

    @GetMapping("/findCart/{id}")
    public Optional<Cart> findCartById(@PathVariable(name = "id") int id){
        return cartService.findCartById(id);
    }
}
