package com.springmart.springmartbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dto.Cart;
import com.springmart.springmartbackend.repository.CartRepository;
import com.stripe.model.Customer;

@Primary
@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    //Create new Cart
    @Override
    public Cart createCart(Cart cart){
        Cart newCart = cartRepository.save(cart);
        return newCart;
    }

    //Find cart by user
     @Override
    public Cart getCart(Long id) {
        Cart foundCart = cartRepository.findById(id).get();
        return foundCart;
    }

    // Get All Cart for Admin
    @Override
    public ArrayList<Cart> getAllCarts() {
        List<Cart> allCart = cartRepository.findAll();
        return (ArrayList<Cart>) allCart;
    }
 
     //Delete Cart
     @Override
     public void deleteCart(Long id) {
         cartRepository.deleteById(id);
     }

    
}
