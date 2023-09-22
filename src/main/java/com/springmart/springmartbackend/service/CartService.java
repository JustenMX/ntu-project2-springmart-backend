package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.entity.Cart;
import com.springmart.springmartbackend.entity.CartItem;

public interface CartService {

    /**
     * CREATE CART UPON USER REGISTRATION
     * 
     * @param cartDto
     * @return
     */
    Cart createCart(Cart cart, SpringUserRegistration springUserRegistration);

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

    CartItem addCartItemToCart(long id, ProductDto productDto);

}
