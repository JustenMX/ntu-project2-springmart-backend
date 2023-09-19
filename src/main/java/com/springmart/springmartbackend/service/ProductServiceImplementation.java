package com.springmart.springmartbackend.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.springmart.springmartbackend.dao.ProductRepository;
import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.Product;
import com.springmart.springmartbackend.entity.ProductCategory;
import com.springmart.springmartbackend.exception.ProductNotFoundException;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;

    @PostConstruct
    public void importProductsOnStartup() {
        try {
            URL url = new URL(
                    "https://raw.githubusercontent.com/JustenMX/ntu-project2-springmart-csv/main/springmart-product.csv?token=GHSAT0AAAAAACHSTGR6H4COKEFUUG4XNXDEZIJ3RNA");
            URLConnection connection = url.openConnection();
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            importProductsFromCSV(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * CREATE PRODUCT
     */
    public Product addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setBrand(productDto.getBrand());
        product.setLabel(productDto.getLabel());
        product.setDescription(productDto.getDescription());
        product.setCurrentPrice(productDto.getCurrentPrice());
        product.setOriginalPrice(productDto.getOriginalPrice());
        product.setSaleItem(productDto.isSaleItem());
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
        updateProduct.setCurrentPrice(productDto.getCurrentPrice());
        updateProduct.setOriginalPrice(productDto.getOriginalPrice());
        updateProduct.setSaleItem(productDto.isSaleItem());
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

    /**
     * IMPORT PRODUCTS FROM CSV
     */
    public void importProductsFromCSV(InputStreamReader reader) {
        try (CSVReader csvReader = new CSVReader(reader)) {
            // Skip the header row
            csvReader.readNext();

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Product product = new Product();
                product.setBrand(nextRecord[0]);
                product.setLabel(nextRecord[1]);
                product.setDescription(nextRecord[2]);
                product.setCurrentPrice(Double.parseDouble(nextRecord[3]));
                product.setOriginalPrice(Double.parseDouble(nextRecord[4]));
                product.setSaleItem(Boolean.parseBoolean(nextRecord[5]));
                product.setProductCategory(ProductCategory.valueOf(nextRecord[6]));
                product.setImgUrl(nextRecord[7]);
                productRepository.save(product);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

}
