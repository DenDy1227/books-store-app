package com.book.booksstore.dto;

import com.book.booksstore.model.CartItem;
import com.book.booksstore.model.User;
import jakarta.persistence.Column;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCartResponseDto {
    private User user;

    private Set<CartItem> cartItems = new HashSet<>();

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
}
