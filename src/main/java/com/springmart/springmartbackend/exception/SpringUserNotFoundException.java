package com.springmart.springmartbackend.exception;

public class SpringUserNotFoundException extends RuntimeException {
    public SpringUserNotFoundException(Long id) {
        super("User not found for id: " + id);
    }
}
