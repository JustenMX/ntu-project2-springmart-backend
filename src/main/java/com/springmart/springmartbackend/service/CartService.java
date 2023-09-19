package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.CartDto;
import com.springmart.springmartbackend.entity.Cart;

public interface CartService {

/**
 * CREATE CART
 */
Cart createCart(CartDto cartDto);

/**
 * GET CART
 */
Cart getCart(Long id);

/**
 * GET ALL CART
 */
List<Cart> getAllCarts();

Cart updateCart(Long id, Cart cart);

/**
 * DELETE CART
 */
void deleteCart(Long id);

}
