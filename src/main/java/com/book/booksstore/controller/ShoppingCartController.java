package com.book.booksstore.controller;

import com.book.booksstore.dto.ShoppingCartResponseDto;
import com.book.booksstore.model.ShoppingCart;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Cart",
        description = "Endpoints for managing user shopping cart.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @GetMapping
    public ShoppingCartResponseDto getShoppingCart() {
    }

    @PutMapping("cart/items/{cartItemId}")
    public ShoppingCartResponseDto updateShoppingCart(@RequestBody ShoppingCart shoppingCart, @PathVariable Long cartItemId) {
    }

}
