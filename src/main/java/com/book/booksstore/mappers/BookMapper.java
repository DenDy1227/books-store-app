package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.BookDtoWithoutCategoryIds;
import com.book.booksstore.dto.CreateBookRequestDto;
import com.book.booksstore.model.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookDto toBookDto(Book book);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Book toBookModel(CreateBookRequestDto createBookRequestDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        book.setCategories(bookDto.getCategoriesIds());
    }
}
