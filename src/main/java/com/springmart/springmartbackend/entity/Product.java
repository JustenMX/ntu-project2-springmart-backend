package com.springmart.springmartbackend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand", nullable = false)
    @NotNull(message = "Brand is required")
    private String brand;

    @Column(name = "label", nullable = false)
    @NotNull(message = "Label is required")
    private String label;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Description is required")
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price is required")
    private Double price;

    @Column(name = "category", nullable = false)
    @NotNull(message = "Category is required")
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @Column(name = "img_url", nullable = false)
    @NotNull(message = "Image url is required")
    private String imgUrl;

    /**
     * Lombak Builder
     */
    @Builder
    public Product(String brand, String label, String description, Double price,
            ProductCategory productCategory, String imgUrl) {
        this.brand = brand;
        this.label = label;
        this.description = description;
        this.price = price;
        this.productCategory = productCategory;
        this.imgUrl = imgUrl;
    }

}