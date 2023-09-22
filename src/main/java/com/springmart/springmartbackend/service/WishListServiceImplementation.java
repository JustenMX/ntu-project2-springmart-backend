package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.springmart.springmartbackend.dao.WishListItemRepository;
import com.springmart.springmartbackend.dao.WishListRepository;
import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.entity.Product;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.entity.WishListItem;
import com.springmart.springmartbackend.exception.WishListNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WishListServiceImplementation implements WishListService {

    private WishListRepository wishListRepository;
    private WishListItemRepository wishListItemRepository;
    private ProductService productService;

    /**
     * CREATE WISHLIST UPON USER REGISTRATION
     */

    @Override
    public WishList createWishList(WishList wishList, SpringUserRegistration springUserRegistration) {

        SpringUser springUser = new SpringUser();
        springUser.setId(springUserRegistration.getId());

        WishList newWishList = new WishList();
        newWishList.setSpringUser(springUser);
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


    @Override
    public WishListItem addWishListItemToWishList(long id, ProductDto productDto) {
       
        WishList selectedWishList = wishListRepository.findById(id).orElseThrow(() -> new WishListNotFoundException(id));

        WishListItem newWishListItem = new WishListItem();

        Long productId = productDto.getId();

        Product product = productService.getProduct(productId);
        newWishListItem.setProductId(product.getId());
        newWishListItem.setBrand(product.getBrand());
        newWishListItem.setLabel(product.getLabel());
        newWishListItem.setDescription(product.getDescription());
        newWishListItem.setCurrentPrice(product.getCurrentPrice());
        newWishListItem.setOriginalPrice(product.getOriginalPrice());
        newWishListItem.setSaleItem(product.isSaleItem());
        newWishListItem.setProductCategory(product.getProductCategory());
        newWishListItem.setImgUrl(product.getImgUrl());

        newWishListItem.setWishList(selectedWishList);
        return wishListItemRepository.save(newWishListItem);

        


    }


 

}
