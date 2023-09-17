package com.springmart.springmartbackend.dto;

import com.springmart.springmartbackend.entity.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String brand;
    private String label;
    private String description;
    private double price;
    private ProductCategory productCategory;
    private String imgUrl;
}
