package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.WishListDto;
import com.springmart.springmartbackend.entity.WishList;

public interface WishListService {

    WishList createWishList(WishListDto wishListDto);

    WishList getWishList(Long id);

    List<WishList> getAllWishList();

    WishList updateWishList(Long id, WishListDto wishListDto);

    void deleteWishList(Long id);

    
}
