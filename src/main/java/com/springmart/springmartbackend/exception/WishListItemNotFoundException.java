package com.springmart.springmartbackend.exception;

public class WishListItemNotFoundException extends RuntimeException{
    public WishListItemNotFoundException(Long id) {
        super("Could not find Wishlist Item" + id);
    }
}
