package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.entity.WishListItem;

public interface WishListItemService {


    /**
     * CREATE WISHLIST ITEM UPON ADD WISHLIST
     * 
     * @return
     */

    WishListItem createWishList(WishListItem wishListItem, WishList WishList);

    /**
     * GET ALL WISHLIST ITEMS FOR ADMIN
     * 
     * 
     * @return
     */
    List<WishListItem> getAllWishListItem();


    /**
     * GET WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */
    WishList getWishList(Long id);

     /**
     * GET WISHLIST ITEM BASE ON THE USERID/WISHLISTID
     * 
     * @return
     */


    /**
     * UPDATE WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */

    WishListItem updateWishListItem(Long id, WishListItem wishListItem);


    /**
     * DELETE WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */

     void deleteWishListItem(Long id);

     




    
    
}
