package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.entity.Cart;
import com.springmart.springmartbackend.entity.CartItem;
import com.springmart.springmartbackend.entity.Product;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.exception.CartNotFoundException;
import com.springmart.springmartbackend.exception.WishListNotFoundException;
import com.springmart.springmartbackend.dao.CartItemRepository;
import com.springmart.springmartbackend.dao.CartRepository;
import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.dto.SpringUserRegistration;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartServiceImplementation implements CartService {

    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private ProductService productService;

    /**
     * CREATE CART UPON USER REGISTRATION
     */
    @Override
    public Cart createCart(Cart cart, SpringUserRegistration springUserRegistration) {
        SpringUser findSpringUser = new SpringUser();
        findSpringUser.setId(springUserRegistration.getId());
        Cart newCart = new Cart();
        newCart.setSpringUser(findSpringUser);
        return cartRepository.save(newCart);
    }

    /**
     * GET ALL CART
     */
    @Override
    public List<Cart> getAllCarts() {
        List<Cart> allCarts = cartRepository.findAll();
        return allCarts;
    }

    /**
     * GET CART
     */
    @Override
    public Cart getCart(Long id) {
        Cart foundCart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
        return foundCart;
    }

    @Override
    public CartItem addCartItemToCart(long id, ProductDto productDto) {

        Cart selectedCart = cartRepository.findById(id).orElseThrow(() -> new WishListNotFoundException(id));

        CartItem newCartItem = new CartItem();

        Long productId = productDto.getId();

        Product product = productService.getProduct(productId);
        newCartItem.setProductId(product.getId());
        newCartItem.setBrand(product.getBrand());
        newCartItem.setLabel(product.getLabel());
        newCartItem.setDescription(product.getDescription());
        newCartItem.setCurrentPrice(product.getCurrentPrice());
        newCartItem.setOriginalPrice(product.getOriginalPrice());
        newCartItem.setSaleItem(product.isSaleItem());
        newCartItem.setProductCategory(product.getProductCategory());
        newCartItem.setImgUrl(product.getImgUrl());
        newCartItem.setQty(1);
        newCartItem.setCart(selectedCart);
        return cartItemRepository.save(newCartItem);

    }

}
