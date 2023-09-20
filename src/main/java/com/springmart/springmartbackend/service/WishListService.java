package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.entity.WishList;

public interface WishListService {

    /**
     * CREATE WISHLIST
     * 
     * @param wishList
     * @return
     */
    WishList createWishList(WishList wishList, Long springuserId);

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

}
