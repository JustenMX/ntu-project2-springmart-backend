package com.springmart.springmartbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.service.WishListService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("springmart/api/wishlist")
public class WishListController {

    private final Logger logger = LoggerFactory.getLogger(WishListController.class);
    private WishListService wishListService;

    /**
     * CREATE WISHLIST
     * 
     * @param wishList
     * @return
     */
    @PostMapping
    public ResponseEntity<WishList> createWishList(@RequestBody WishList wishList, Long springuserId) {
        WishList newWishList = wishListService.createWishList(wishList, springuserId);
        logger.info("Added new WishList [ID: {}]", wishList.getId());
        return new ResponseEntity<WishList>(newWishList, HttpStatus.CREATED);
    }

    /**
     * GET ALL WISHLIST
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<WishList>> getAllWishList() {
        List<WishList> allWishList = wishListService.getAllWishList();
        return new ResponseEntity<>(allWishList, HttpStatus.OK);
    }

    /**
     * GET WISHLIST
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<WishList> getWishlist(@PathVariable Long id) {
        WishList foundWishList = wishListService.getWishList(id);
        return new ResponseEntity<>(foundWishList, HttpStatus.OK);

    }

}
