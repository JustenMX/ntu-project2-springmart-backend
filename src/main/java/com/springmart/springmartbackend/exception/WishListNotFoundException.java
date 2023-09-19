package com.springmart.springmartbackend.exception;

public class WishListNotFoundException extends RuntimeException {

    public WishListNotFoundException(Long id) {
        super("Could not find Wishlist " + id);
    }
    
}
