package com.springmart.springmartbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.ProductDto;
import com.springmart.springmartbackend.entity.Cart;
import com.springmart.springmartbackend.entity.CartItem;
import com.springmart.springmartbackend.service.CartService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("springmart/api/cart")
public class CartController {

  private final Logger logger = LoggerFactory.getLogger(CartController.class);
  private CartService cartService;

  /**
   * GET ALL CART
   * 
   * @return
   */
  @GetMapping
  public ResponseEntity<List<Cart>> getAllCart() {
    List<Cart> allCarts = cartService.getAllCarts();
    logger.info("Retrieved {} carts successfully", allCarts.size());
    return new ResponseEntity<>(allCarts, HttpStatus.OK);
  }

  /**
   * GET CART
   * 
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public ResponseEntity<Cart> getCart(@PathVariable Long id) {
    Cart foundCart = cartService.getCart(id);
    logger.info("Retrieved cart [ID: {}]", foundCart.getId());
    return new ResponseEntity<>(foundCart, HttpStatus.OK);

  }

  @PostMapping("/{id}/cartitem")
    public ResponseEntity<CartItem> addCartItemToCart(@PathVariable long id, @RequestBody ProductDto productDto) {
        CartItem newCartItem = cartService.addCartItemToCart(id, productDto);
        return new ResponseEntity<>(newCartItem, HttpStatus.OK);
    }

}
