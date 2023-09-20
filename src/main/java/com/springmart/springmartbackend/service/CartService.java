package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.entity.Cart;

public interface CartService {

    /**
     * CREATE CART
     * 
     * @param cartDto
     * @return
     */
    Cart createCart(Cart cart);

    /**
     * GET ALL CART
     * 
     * @return
     */
    List<Cart> getAllCarts();

    /**
     * GET CART
     * 
     * @param id
     * @return
     */
    Cart getCart(Long id);

}
