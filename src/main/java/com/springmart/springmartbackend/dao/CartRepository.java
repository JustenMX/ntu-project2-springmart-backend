package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    
}
