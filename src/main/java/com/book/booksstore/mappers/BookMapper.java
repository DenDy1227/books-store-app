package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.CreateBookRequestDto;
import com.book.booksstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookDto toBookDto(Book book);

    Book toBookModel(CreateBookRequestDto createBookRequestDto);
}
