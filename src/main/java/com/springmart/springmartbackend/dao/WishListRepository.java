package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmart.springmartbackend.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

}
