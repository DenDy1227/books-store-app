package com.book.booksstore.dto;

import lombok.Data;

@Data
public class AddCartItemRequest {
    private Long bookId;
    private int quantity;
    private Long userId;
}
