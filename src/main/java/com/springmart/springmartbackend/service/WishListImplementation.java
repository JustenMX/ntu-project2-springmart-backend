package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.WishListRepository;
import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.exception.CartNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WishListImplementation implements WishListService{

    private WishListRepository wishListRepository;

    @Override
    public WishList createWishList(WishList wishList){
     WishList newWishList = new WishList();
      newWishList.setMessage(wishList.getMessage());
      return wishListRepository.save(newWishList);
    }

    /**
 * GET CART
 */
     @Override
    public WishList getWishList(Long id) {
        WishList foundWishList = wishListRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
        return foundWishList;
    }


/**
 * GET ALL WISHLIST (ADMIN PORTAL)
 */
    @Override
    public List<WishList> getAllWishList() {
        List<WishList> allWishLists = wishListRepository.findAll();
        return allWishLists;
    }

/**
 * UPDATE WISHLIST (ADMIN PORTAL)
 */

    @Override
    public WishList updateWishList(Long id, WishList wishList) {
        // retrieve the customer from the database
        WishList wishListToUpdate = wishListRepository.findById(id).get();
        // update the customer retrieved from the database
        wishListToUpdate.setMessage(wishList.getMessage());


        // save the updated customer back to the database
        return wishListRepository.save(wishListToUpdate);
    }
 
/**
 * DELETE CART
 */
     @Override
     public void deleteWishList(Long id) {
         wishListRepository.deleteById(id);
     }

    
}
