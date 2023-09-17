package com.springmart.springmartbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.Product;
import com.springmart.springmartbackend.service.ProductServiceImplementation;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/springmart/api/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductServiceImplementation productService;

    /**
     * CREATE PRODUCT
     * 
     * @param productDto
     * @return
     */
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
        logger.info("Added new product [ID: {}, Brand: {}, Label: {}]", productDto.getId(), productDto.getBrand(),
                productDto.getLabel());
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.OK);
    }

    /**
     * GET ALL PRODUCTS
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        logger.info("Retrieved {} products successfully", allProducts.size());
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    /**
     * GET ALL PRODUCTS
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        logger.info("Retrieved product [ID: {}, Brand: {}, Label: {}] successfully", product.getId(),
                product.getBrand(), product.getLabel());
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * UPDATE PRODUCT
     * 
     * @param id
     * @param productDto
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product updateProduct = productService.getProduct(id);
        logger.info("Retrieved product [ID: {}, Brand: {}, Label: {}] successfully", updateProduct.getId(),
                updateProduct.getBrand(), updateProduct.getLabel());
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    /**
     * DELETE PRODUCT
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
