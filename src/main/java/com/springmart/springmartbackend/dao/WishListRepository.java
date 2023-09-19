package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    
}
