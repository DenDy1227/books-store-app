package com.book.booksstore.service;

import com.book.booksstore.dto.ShoppingCartResponseDto;

public interface ShoppingCartService {

    ShoppingCartResponseDto getShoppingCart(Long cartItemId);

    ShoppingCartResponseDto updateItemQuantity(
            Long cartItemId,
            int quantity);

    void createShoppingCart(Long userId);

    ShoppingCartResponseDto addBook(Long bookId, int quantity);

    ShoppingCartResponseDto deleteItemFromShoppingCart(Long cartItemId);
}
