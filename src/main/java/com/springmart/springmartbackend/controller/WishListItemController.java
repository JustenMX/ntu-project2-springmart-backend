package com.springmart.springmartbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.WishListItem;
import com.springmart.springmartbackend.service.WishListItemService;
import com.stripe.param.PriceCreateParams.ProductData;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("springmart/api/wishlistitem")
public class WishListItemController {

    private WishListItemService wishListItemService;

    // @PostMapping
    // public ResponseEntity<WishListItem> createWishListItem(@RequestBody WishListItem wishListItem, @RequestBody ProductDto productDto) {
    //     WishListItem newWishListItem = wishListItemService.createWishListItem(wishListItem, productDto);
    //     return new ResponseEntity<WishListItem>(newWishListItem, HttpStatus.CREATED);

    // }

    @GetMapping
    public ResponseEntity<List<WishListItem>> getAllWishListItems() {
        List<WishListItem> allWishListItem = wishListItemService.getAllWishListItems();
        return new ResponseEntity<>(allWishListItem, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishListItem> getWishListItem(@PathVariable Long id) {
        WishListItem foundWishListItem = wishListItemService.getWishListItem(id);
        return new ResponseEntity<>(foundWishListItem, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteWishListItem(@PathVariable Long id) {
        wishListItemService.deleteWishListItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @GetMapping("/search"){

    // }


    
}
