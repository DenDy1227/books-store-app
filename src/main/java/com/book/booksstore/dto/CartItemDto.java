package com.book.booksstore.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {
    private Long id;
    private Long bookId;
    private String bookTitle;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}
