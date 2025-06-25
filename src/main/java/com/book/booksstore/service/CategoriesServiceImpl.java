package com.book.booksstore.service;

import com.book.booksstore.dto.CategoryRequestDto;
import com.book.booksstore.dto.CategoryResponseDto;
import com.book.booksstore.exception.EntityNotFoundException;
import com.book.booksstore.mappers.CategoryMapper;
import com.book.booksstore.model.Category;
import com.book.booksstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public Page<CategoryResponseDto> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    @Override
    public CategoryRequestDto getCategoryById(Long id) {
        return categoryMapper.toResponseDto(
                categoryRepository.getReferenceById(id));
    }

    @Override
    public CategoryRequestDto saveCategory(
            CategoryResponseDto categoryResponseDto) {
        return categoryMapper.toResponseDto(categoryRepository
                .save(categoryMapper
                        .toEntity(categoryResponseDto))
        );
    }

    @Override
    public CategoryRequestDto updateCategory(
            Long id,
            CategoryResponseDto categoryResponseDto) {
        Category existing = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Category not found with id " + id));
        categoryMapper.updateCategoryFromDto(categoryResponseDto, existing);
        return categoryMapper.toResponseDto(
                categoryRepository.save(existing)
        );
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
