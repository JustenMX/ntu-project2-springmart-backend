package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.ProductRepository;
import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.Product;
import com.springmart.springmartbackend.exception.ProductNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;

    /**
     * CREATE PRODUCT
     */
    public Product addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setBrand(productDto.getBrand());
        product.setLabel(productDto.getLabel());
        product.setDescription(productDto.getDescription());
        product.setProductCategory(productDto.getProductCategory());
        product.setImgUrl(productDto.getImgUrl());
        return productRepository.save(product);
    }

    /**
     * GET ALL PRODUCTS
     */
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    /**
     * GET ONE PRODUCT
     */
    public Product getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return product;
    }

    /**
     * UPDATE PRODUCT
     */
    public Product updateProduct(Long id, ProductDto productDto) {
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        updateProduct.setBrand(productDto.getBrand());
        updateProduct.setLabel(productDto.getLabel());
        updateProduct.setDescription(productDto.getDescription());
        updateProduct.setProductCategory(productDto.getProductCategory());
        updateProduct.setImgUrl(productDto.getImgUrl());
        return productRepository.save(updateProduct);
    }

    /**
     * DELETE PRODUCT
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
