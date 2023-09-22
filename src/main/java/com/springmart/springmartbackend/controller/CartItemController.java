package com.springmart.springmartbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.SpringUserDto;
import com.springmart.springmartbackend.entity.CartItem;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.entity.WishListItem;
import com.springmart.springmartbackend.service.CartItemService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("springmart/api/cartitem")
public class CartItemController {

    private CartItemService cartItemService;

     @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> allCartItem = cartItemService.getAllCartItems();
        return new ResponseEntity<>(allCartItem, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItem(@PathVariable Long id) {
        CartItem foundCartItem = cartItemService.getCartItem(id);
        return new ResponseEntity<>(foundCartItem, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id,@RequestBody int qty) {
        CartItem updateCartItem = cartItemService.updateCartItem(id, qty);
        return new ResponseEntity<>(updateCartItem, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}
