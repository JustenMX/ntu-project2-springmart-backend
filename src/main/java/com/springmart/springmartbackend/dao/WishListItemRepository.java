package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmart.springmartbackend.entity.WishListItem;
import java.util.List;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem, Long> {
     List<WishListItem> findByWishListId(Long wishList);

}
