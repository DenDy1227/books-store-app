package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.CartItemDto;
import com.book.booksstore.dto.ShoppingCartResponseDto;
import com.book.booksstore.exception.EntityNotFoundException;
import com.book.booksstore.model.Book;
import com.book.booksstore.model.CartItem;
import com.book.booksstore.model.ShoppingCart;
import com.book.booksstore.repository.BookRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = MapperConfig.class)
public abstract class ShoppingCartMapper {

    @Autowired
    protected BookRepository bookRepository;

    @Mapping(
            target = "book",
            source = "bookId",
            qualifiedByName = "bookFromId")
    public abstract CartItem toCartItem(CartItemDto dto);

    @Mapping(target = "userId", source = "user.id")
    public abstract ShoppingCartResponseDto toDto(ShoppingCart cart);

    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "bookTitle", source = "book.title")
    public abstract CartItemDto toDto(CartItem item);

    @Named("bookFromId")
    public Book bookFromId(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Book not found: " + bookId));
    }
}
