package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.entity.WishList;

public interface WishListService {

    WishList createWishList(WishList wishList);

    WishList getWishList(Long id);

    List<WishList> getAllWishList();

    void deleteWishList(Long id);

    
}
