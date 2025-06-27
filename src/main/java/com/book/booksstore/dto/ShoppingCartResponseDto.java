package com.book.booksstore.dto;

import com.book.booksstore.model.CartItem;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long cartId;
    private Set<CartItem> cartItems = new HashSet<>();
    private Long userId;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    private int totalItems;
    private BigDecimal totalPrice;
}
