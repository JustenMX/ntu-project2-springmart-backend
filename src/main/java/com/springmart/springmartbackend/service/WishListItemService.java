package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.WishListItem;

public interface WishListItemService {

    /**
     * CREATE WISHLIST ITEM UPON ADD WISHLIST
     * 
     * @return
     */

    WishListItem createWishListItem(WishListItem wishListItem, ProductDto productDto);

    /**
     * GET ALL WISHLIST ITEMS FOR ADMIN
     * 
     * 
     * @return
     */
    List<WishListItem> getAllWishListItems();

    /**
     * GET WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */
    WishListItem getWishListItem(Long id);


    /**
     * DELETE WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */

    void deleteWishListItem(Long id);

    List<WishListItem> searchWishListItemsById(Long id);

}
