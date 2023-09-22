package com.springmart.springmartbackend.exception;

public class CartItemNotFoundException extends RuntimeException{
    public CartItemNotFoundException(Long id) {
        super("Could not find Cart Item " + id);
    }
    
}
