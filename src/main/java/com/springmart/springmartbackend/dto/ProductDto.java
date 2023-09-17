package com.springmart.springmartbackend.dto;

import com.springmart.springmartbackend.entity.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    Long id;
    String brand;
    String label;
    String description;
    ProductCategory productCategory;
    String imgUrl;
}
