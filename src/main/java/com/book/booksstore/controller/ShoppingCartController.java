package com.book.booksstore.controller;

import com.book.booksstore.dto.AddCartItemRequest;
import com.book.booksstore.dto.ShoppingCartResponseDto;
import com.book.booksstore.dto.UpdateCartItemRequest;
import com.book.booksstore.service.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    private final ShoppingCartService shoppingCartService;

    @Operation(
            summary = "Get shopping cart.",
            description = "Return current authenticated user shopping cart.")
    @GetMapping
    public ShoppingCartResponseDto getShoppingCart(Long cartItemId) {
        return shoppingCartService.getShoppingCart(cartItemId);
    }

    @Operation(
            summary = "Add book.",
            description = "Add book to shopping cart.")
    @PostMapping
    public ShoppingCartResponseDto addItem(
            @RequestBody @Valid AddCartItemRequest req) {
        return shoppingCartService.addBook(req.getBookId(), req.getQuantity());
    }

    @Operation(
            summary = "Update shopping cart.",
            description = "Change quantity of specific book in the cart.")
    @PutMapping("cart/items/{cartItemId}")
    public ShoppingCartResponseDto updateShoppingCart(
            @PathVariable Long cartItemId,
            @RequestBody @Valid UpdateCartItemRequest req) {
        return shoppingCartService
                .updateItemQuantity(cartItemId, req.getQuantity());
    }

    @Operation(
            summary = "Delete book from cart.",
            description = "Violent deleting book from shopping cart.")
    @DeleteMapping("cart/items/{cartItemId}")
    public ShoppingCartResponseDto deleteShoppingCart(
            @PathVariable Long cartItemId) {
        return shoppingCartService.deleteItemFromShoppingCart(cartItemId);
    }
}
