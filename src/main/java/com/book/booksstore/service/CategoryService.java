package com.book.booksstore.service;

import com.book.booksstore.dto.CategoryRequestDto;
import com.book.booksstore.dto.CategoryResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryResponseDto> findAll(Pageable pageable);

    CategoryRequestDto getCategoryById(Long id);

    CategoryRequestDto saveCategory(CategoryResponseDto categoryResponseDto);

    CategoryRequestDto updateCategory(
            Long id,
            CategoryResponseDto categoryResponseDto);

    void deleteCategoryById(Long id);
}
