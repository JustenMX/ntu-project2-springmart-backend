package com.springmart.springmartbackend.exception;

public class SpringUserAuthNotFoundException extends RuntimeException {
    public SpringUserAuthNotFoundException(Long id) {
        super("Auth user not found for id: " + id);
    }
}
