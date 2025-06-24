package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.CategoryDto;
import com.book.booksstore.dto.CategoryResponseDto;
import com.book.booksstore.model.Category;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    CategoryResponseDto toResponseDto(Category category);

    Category toEntity(CategoryDto categoryDto);
}
