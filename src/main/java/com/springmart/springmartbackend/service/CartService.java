package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.CartDto;
import com.springmart.springmartbackend.entity.Cart;

public interface CartService {

    /**
     * CREATE CART
     * 
     * @param cartDto
     * @return
     */
    Cart createCart(CartDto cartDto);

    /**
     * GET CART
     * 
     * @param id
     * @return
     */
    Cart getCart(Long id);

    /**
     * GET ALL CART
     * 
     * @return
     */
    List<Cart> getAllCarts();

    /**
     * UPDATE CART
     * 
     * @param id
     * @param cart
     * @return
     */
    Cart updateCart(Long id, Cart cart);

    /**
     * DELETE CART
     * 
     * @param id
     */
    void deleteCart(Long id);

}
