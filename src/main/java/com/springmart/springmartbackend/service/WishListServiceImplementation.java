package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.ProductRepository;
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
    private ProductRepository productRepository;

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
        // Product newProduct = new Product();
        newWishListItem.setId(productDto.getId());
        newWishListItem.setBrand(productDto.getBrand());
        newWishListItem.setLabel(productDto.getLabel());
        newWishListItem.setDescription(productDto.getDescription());
        newWishListItem.setCurrentPrice(productDto.getCurrentPrice());
        newWishListItem.setOriginalPrice(productDto.getOriginalPrice());
        newWishListItem.setSaleItem(productDto.isSaleItem());
        newWishListItem.setProductCategory(productDto.getProductCategory());
        newWishListItem.setImgUrl(productDto.getImgUrl());
        // newWishListItem.setProduct(newProduct);

        newWishListItem.setWishList(selectedWishList);
        return wishListItemRepository.save(newWishListItem);
    }

    // @Override
    // public List<WishListItem> getWishListItemByUser(long id){
    //     List<WishListItem> allWishListItems = wishListItemRepository.findAllById(id).orElseThrow(() -> new WishListNotFoundException(id));
    // }

 

}
