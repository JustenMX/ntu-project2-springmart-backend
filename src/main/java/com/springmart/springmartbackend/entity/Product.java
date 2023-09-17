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
    Long id;

    @Column(name = "brand")
    @NotNull(message = "Brand is required")
    String brand;

    @Column(name = "label")
    @NotNull(message = "Label is required")
    String label;

    @Column(name = "description")
    @NotNull(message = "Description is required")
    String description;

    @Column(name = "category")
    @NotNull(message = "Category is required")
    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;

    @Column(name = "img_url")
    @NotNull(message = "Image url is required")
    String imgUrl;
}
