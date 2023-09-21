package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.entity.WishListItem;
import java.util.List;


public interface WishListItemRepository extends JpaRepository<WishListItem, Long> {
    List<WishListItem> findByWishListId(Long wishList);
    
}
