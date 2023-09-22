package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.CartItemRepository;
import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.CartItem;
import com.springmart.springmartbackend.exception.CartItemNotFoundException;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartItemServiceImplementation implements CartItemService {

    private CartItemRepository cartItemRepository;

    /**
     * CREATE WISHLIST ITEM UPON ADD TO WISHLIST
     */

    @Override
    public CartItem createCartItem(CartItem cartItem, ProductDto productDto) {

        return cartItemRepository.save(cartItem);

    }

    /**
     * GET ALL WISHLIST ITEMS
     */

    @Override
    public List<CartItem> getAllCartItems() {
        List<CartItem> allCartItems = cartItemRepository.findAll();
        return allCartItems;
    }

    /**
     * GET WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */
    @Override
    public CartItem getCartItem(Long id) {
        CartItem foundCartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new CartItemNotFoundException(id));

        return foundCartItem;
    }

    /**
     * UPDATE USER
     */
    @Override
    public CartItem updateCartItem(Long id, int qty) {
        CartItem updateCartItem = cartItemRepository.findById(id).orElseThrow(() -> new CartItemNotFoundException(id));
        updateCartItem.setQty(qty);
        return updateCartItem;
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

 

}
