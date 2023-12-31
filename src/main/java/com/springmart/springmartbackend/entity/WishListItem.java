package com.springmart.springmartbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wishlistitem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "brand", nullable = false)
    @NotNull(message = "Brand is required")
    private String brand;

    @Column(name = "label", nullable = false)
    @NotNull(message = "Label is required")
    private String label;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Description is required")
    private String description;

    @Column(name = "current_price", nullable = false)
    @NotNull(message = "Current price is required")
    private Double currentPrice;

    @Column(name = "original_price", nullable = false)
    @NotNull(message = "Orignal price is required")
    private Double originalPrice;

    @Column(name = "is_sale_item", nullable = false)
    @NotNull(message = "Orignal price is required")
    private boolean saleItem;

    @Column(name = "category", nullable = false)
    @NotNull(message = "Category is required")
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @Column(name = "img_url", nullable = false)
    @NotNull(message = "Image url is required")
    private String imgUrl;

    /**
     * MANY TO ONE
     */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
    private WishList wishList;

}
