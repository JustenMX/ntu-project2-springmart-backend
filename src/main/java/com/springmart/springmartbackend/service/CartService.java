package com.springmart.springmartbackend.service;

import java.util.ArrayList;

import com.springmart.springmartbackend.entity.Cart;

public interface CartService {

    Cart createCart(Cart cart);
    Cart getCart(Long id);
    ArrayList<Cart> getAllCarts();
    void deleteCart(Long id);

    
}
