package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.Product;

public interface ProductService {

    /**
     * CREATE PRODUCT
     * 
     * @param productDto
     * @return
     */
    Product addProduct(ProductDto productDto);

    /**
     * GET ALL PRODUCTS
     * 
     * @return
     */
    List<Product> getAllProducts();

    /**
     * GET ONE PRODUCT
     * 
     * @param id
     * @return
     */
    Product getProduct(Long id);

    /**
     * UPDATE PRODUCT
     * 
     * @param id
     * @param productDto
     * @return
     */
    Product updateProduct(Long id, ProductDto productDto);

    /**
     * DELETE PRODUCT
     * 
     * @param id
     */
    void deleteProduct(Long id);
}
