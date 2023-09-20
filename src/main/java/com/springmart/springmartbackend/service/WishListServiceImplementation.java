package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.WishListRepository;
import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.exception.WishListNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WishListServiceImplementation implements WishListService {

    private WishListRepository wishListRepository;

    /**
     * CREATE WISHLIST
     */

    @Override
    public WishList createWishList(WishList wishList) {
        WishList newWishList = new WishList();
        return wishListRepository.save(newWishList);
    }

    /**
     * GET ALL WISHLIST
     */
    @Override
    public List<WishList> getAllWishList() {
        List<WishList> allWishLists = wishListRepository.findAll();
        return allWishLists;
    }

    /**
     * GET WISHLIST
     */
    @Override
    public WishList getWishList(Long id) {
        WishList foundWishList = wishListRepository.findById(id).orElseThrow(() -> new WishListNotFoundException(id));
        return foundWishList;
    }

}
