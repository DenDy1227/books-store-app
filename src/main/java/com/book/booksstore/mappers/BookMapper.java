package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.BookDtoWithoutCategoryIds;
import com.book.booksstore.dto.CreateBookRequestDto;
import com.book.booksstore.model.Book;
import com.book.booksstore.model.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    @Mapping(
            target = "categoryIds",
            source = "categories"
    )
    BookDto toBookDto(Book book);

    default Set<Long> mapCategories(
            Set<Category> categories) {
        return categories.stream()
                .map(Category::getId)
                .collect(Collectors.toSet());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Book toBookModel(CreateBookRequestDto createBookRequestDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);
    
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        book.setCategories(bookDto.getCategoriesIds());
    }
}
