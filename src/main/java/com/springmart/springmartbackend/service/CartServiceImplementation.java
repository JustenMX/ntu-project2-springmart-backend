package com.springmart.springmartbackend.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.entity.Cart;
import com.springmart.springmartbackend.exception.CartNotFoundException;
import com.springmart.springmartbackend.dao.CartRepository;
import com.springmart.springmartbackend.dto.CartDto;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CartServiceImplementation implements CartService {

    private CartRepository cartRepository;

/**
 * CREATE CART
 */
    @Override
    public Cart createCart(CartDto cartDto){
      Cart newCart = new Cart();
      newCart.setMessage(cartDto.getMessage());
      return cartRepository.save(newCart);
    }


/**
 * GET CART
 */
     @Override
    public Cart getCart(Long id) {
        Cart foundCart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
        return foundCart;
    }


/**
 * GET ALL CART (ADMIN PORTAL)
 */
    @Override
    public List<Cart> getAllCarts() {
        List<Cart> allCarts = cartRepository.findAll();
        return allCarts;
    }
 
/**
 * DELETE CART
 */
     @Override
     public void deleteCart(Long id) {
         cartRepository.deleteById(id);
     }

    
}
