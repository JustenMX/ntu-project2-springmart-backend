package com.springmart.springmartbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.CartDto;
import com.springmart.springmartbackend.entity.Cart;

import com.springmart.springmartbackend.service.CartServiceImplementation;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

// import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173") // npm run dev in local frontend
@RestController
@RequestMapping("springmart/api/cart")
@AllArgsConstructor
public class CartController {
    
    private CartServiceImplementation cartService;

    /**
     * CREATE
     */
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartDto cartDto) {
       
        return new ResponseEntity<>(cartService.createCart(cartDto), HttpStatus.CREATED);
    }

    //Read (Get All the Carts)
     @GetMapping
    public ResponseEntity<List<Cart>> getAllCart() {
        List<Cart> allCarts = cartService.getAllCarts();
        return new ResponseEntity<>(allCarts, HttpStatus.OK);
    }

    // Read (GET ONE)
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
            Cart foundCart = cartService.getCart(id);
            return new ResponseEntity<>(foundCart, HttpStatus.OK);
       
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCart(@PathVariable Long id) {
      cartService.deleteCart(id);
            return new ResponseEntity<>(HttpStatus.OK);

    }



}
