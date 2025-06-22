package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.CreateBookRequestDto;
import com.book.booksstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookDto toBookDto(Book book);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Book toBookModel(CreateBookRequestDto createBookRequestDto);
}
