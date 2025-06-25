package com.book.booksstore.service;

import com.book.booksstore.dto.CategoryRequestDto;
import com.book.booksstore.dto.CategoryResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryResponseDto> findAll(Pageable pageable);

    CategoryRequestDto getById(Long id);

    CategoryRequestDto save(CategoryResponseDto categoryResponseDto);

    CategoryRequestDto update(Long id, CategoryResponseDto categoryResponseDto);

    void deleteById(Long id);
}
