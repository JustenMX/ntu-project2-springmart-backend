package com.springmart.springmartbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmart.springmartbackend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
