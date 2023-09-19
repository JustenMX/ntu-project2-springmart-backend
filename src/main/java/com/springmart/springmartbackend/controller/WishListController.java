package com.springmart.springmartbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.CartDto;
import com.springmart.springmartbackend.dto.WishListDto;
import com.springmart.springmartbackend.entity.Cart;
import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.exception.CartNotFoundException;
import com.springmart.springmartbackend.service.WishListService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("springmart/api/wishlist")
@AllArgsConstructor
public class WishListController {

    private WishListService wishListService;

    @PostMapping
    public ResponseEntity<WishList> createWishList(@RequestBody WishListDto wishListDto) {
        WishList newWishList = wishListService.createWishList(wishListDto);
        return new ResponseEntity<WishList>(newWishList, HttpStatus.CREATED);
    }

    // Read (Get All the Wishlist)
    @GetMapping
    public ResponseEntity<List<WishList>> getAllWishList() {
        List<WishList> allWishList = wishListService.getAllWishList();
        return new ResponseEntity<>(allWishList, HttpStatus.OK);
    }

    // Read (GET ONE)
    @GetMapping("/{id}")
    public ResponseEntity<WishList> getWishlist(@PathVariable Long id) {
        WishList foundWishList = wishListService.getWishList(id);
        return new ResponseEntity<>(foundWishList, HttpStatus.OK);

    }

    // Update (A user Wishlist)
    @PutMapping("{id}")
    public ResponseEntity<WishList> updateWishList(@PathVariable Long id, @RequestBody WishListDto wishListDto) {

        try {
            WishList updatedWishList = wishListService.updateWishList(id, wishListDto);
            return new ResponseEntity<>(updatedWishList, HttpStatus.OK);
        } catch (CartNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWishList(@PathVariable Long id) {
        wishListService.deleteWishList(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
