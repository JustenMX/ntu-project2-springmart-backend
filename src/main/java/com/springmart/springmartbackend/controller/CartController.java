package com.springmart.springmartbackend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.Cart;
import com.springmart.springmartbackend.exception.CartNotFoundException;
import com.springmart.springmartbackend.service.CartService;
import com.stripe.model.Customer;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

// import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cart")
// @AllArgsConstructor
public class CartController {
    
    private CartService cartService;


    //Create
    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    //
    @PostMapping("")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart newCart = cartService.createCart(cart);
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }

    //Read (Get All the Carts)
     @PostMapping("")
    public ResponseEntity<ArrayList<Cart>> getAllCart() {
        ArrayList<Cart> allCarts = cartService.getAllCarts();
        return new ResponseEntity<>(allCarts, HttpStatus.OK);
    }

    // Read (GET ONE)
    @GetMapping("{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {

        try {
            Cart foundCart = cartService.getCart(id);
            return new ResponseEntity<>(foundCart, HttpStatus.OK);
          } catch (CartNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }

     @DeleteMapping("{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable Long id) {
        // int index = getCustomerIndex(id);
        // return customers.remove(index);

        try {
            cartService.deleteCart(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          } catch (CartNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }



}
