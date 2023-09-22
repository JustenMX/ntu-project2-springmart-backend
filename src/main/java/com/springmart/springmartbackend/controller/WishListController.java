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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.entity.WishListItem;
import com.springmart.springmartbackend.service.WishListService;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("springmart/api/wishlist")
public class WishListController {

    private final Logger logger = LoggerFactory.getLogger(WishListController.class);
    private WishListService wishListService;

    /**
     * GET ALL WISHLIST
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<WishList>> getAllWishList() {
        List<WishList> allWishList = wishListService.getAllWishList();
        logger.info("Retrieved {} wishlists successfully", allWishList.size());
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
        logger.info("Retrieved allWishList [ID: {}] successfully", foundWishList.getId());
        return new ResponseEntity<>(foundWishList, HttpStatus.OK);

    }

    @PostMapping("/{id}/wishlistitem")
    public ResponseEntity<WishListItem> addWishListItemToWishList(@PathVariable long id, @RequestBody ProductDto productDto) {
        WishListItem newWishListItem = wishListService.addWishListItemToWishList(id, productDto);
        return new ResponseEntity<>(newWishListItem, HttpStatus.OK);
    }

    // @GetMapping("/{id}/wishlistitem")
    // public ResponseEntity<List<WishListItem>> getWishListItemByUser(@PathVariable long id) {
    //     return new ResponseEntity<>(wishListService.getWishListItemByUser(id), HttpStatus.OK);
    // }

    
   

}
