package com.book.booksstore.mappers;

import com.book.booksstore.dto.CartItemDto;
import com.book.booksstore.model.CartItem;
import org.mapstruct.Mapping;

public interface CartItemMapper {
    @Mapping(target = "book.id", source = "bookId")
    CartItem toCartItem(CartItemDto dto);

    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "bookTitle", source = "book.title")
    CartItemDto toDto(CartItem item);
}
