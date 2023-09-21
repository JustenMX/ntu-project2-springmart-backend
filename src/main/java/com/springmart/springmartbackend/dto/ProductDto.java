package com.springmart.springmartbackend.dto;

import com.springmart.springmartbackend.entity.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String brand;
    private String label;
    private String description;
    private double currentPrice;
    private double originalPrice;
    private boolean saleItem;
    private ProductCategory productCategory;
    private String imgUrl;
}
