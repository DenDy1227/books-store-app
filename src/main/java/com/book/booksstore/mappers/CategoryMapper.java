package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.CategoryRequestDto;
import com.book.booksstore.dto.CategoryResponseDto;
import com.book.booksstore.model.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {

    CategoryResponseDto toDto(Category category);

    CategoryRequestDto toResponseDto(Category category);

    Category toEntity(CategoryResponseDto categoryResponseDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromDto(
            CategoryResponseDto dto,
            @MappingTarget Category entity);
}
