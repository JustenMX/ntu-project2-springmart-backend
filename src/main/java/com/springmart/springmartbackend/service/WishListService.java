package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.entity.WishListItem;

public interface WishListService {

    /**
     * CREATE WISHLIST UPON USER REGISTRATION
     * 
     * @param wishList
     * @return
     */
    WishList createWishList(WishList wishList, SpringUserRegistration springUserRegistration);

    /**
     * GET ALL WISHLIST
     * 
     * @return
     */
    List<WishList> getAllWishList();

    /**
     * GET WISHLIST
     * 
     * @param id
     * @return
     */
    WishList getWishList(Long id);

    /**
     * ADD WISHLIST ITEM TO WISHLIST
     * 
     * @param id
     * @param productDto
     * @return
     */
    WishListItem addWishListItemToWishList(long id, ProductDto productDto);

}
