package com.springmart.springmartbackend.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(Long id) {
        super("Could not find Cart " + id);
    }
}
