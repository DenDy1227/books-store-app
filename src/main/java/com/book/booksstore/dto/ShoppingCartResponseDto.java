package com.book.booksstore.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long cartId;
    private Set<CartItemDto> cartItems = new HashSet<>();
    private Long userId;
    private int totalItems;
    private BigDecimal totalPrice;
}
