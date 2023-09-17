package com.springmart.springmartbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.dto.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
