package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.WishListItemRepository;
import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.WishListItem;
import com.springmart.springmartbackend.exception.WishListItemNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WishListItemServiceImplementation implements WishListItemService {

    private WishListItemRepository wishListItemRepository;

    /**
     * CREATE WISHLIST ITEM UPON ADD TO WISHLIST
     */

    @Override
    public WishListItem createWishListItem(WishListItem wishListItem, ProductDto productDto) {

        return wishListItemRepository.save(wishListItem);

    }

    /**
     * GET ALL WISHLIST ITEMS
     */

    @Override
    public List<WishListItem> getAllWishListItems() {
        List<WishListItem> allWishListItems = wishListItemRepository.findAll();
        return allWishListItems;
    }

    /**
     * GET WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */
    @Override
    public WishListItem getWishListItem(Long id) {
        WishListItem foundWishListItem = wishListItemRepository.findById(id)
                .orElseThrow(() -> new WishListItemNotFoundException(id));

        return foundWishListItem;

    }

    @Override
    public void deleteWishListItem(Long id) {
        wishListItemRepository.deleteById(id);
    }

    @Override
    public List<WishListItem> searchWishListItemsById(Long id) {
        List<WishListItem> foundWishListItemsById = wishListItemRepository.findByWishListId(id);
        return (List<WishListItem>) foundWishListItemsById;
    }

}
