package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.dto.SpringUserDto;
import com.springmart.springmartbackend.entity.CartItem;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.entity.WishListItem;

public interface CartItemService {

      /**
     * CREATE WISHLIST ITEM UPON ADD WISHLIST
     * 
     * @return
     */

    CartItem createCartItem(CartItem cartItem, ProductDto productDto);

    /**
     * GET ALL WISHLIST ITEMS FOR ADMIN
     * 
     * 
     * @return
     */
    List<CartItem> getAllCartItems();

    /**
     * GET WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */
    CartItem getCartItem(Long id);


    /**
     * UPDATE CART ITEM
     * 
     * @param id
     * @param qty
     * @return
     */
    CartItem updateCartItem(Long id, int qty);

 
    /**
     * DELETE WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */

    void deleteCartItem(Long id);

    // List<CartItem> searchCartItems(Long id);

    
}
