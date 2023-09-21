package com.springmart.springmartbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("springmart/api/wishlistitem")
public class WishListItemController {

    @GetMapping
    public ResponseEntity<List<WishListItem>> getAllWishListItem() {
        List<WishListItem> allWishListItem = wishListItemService.getAllWishListItem();
    }


    
}
