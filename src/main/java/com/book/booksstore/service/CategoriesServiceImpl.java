package com.book.booksstore.service;

import com.book.booksstore.dto.CategoryDto;
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
    public Page<CategoryDto> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        return categoryMapper.toResponseDto(
                categoryRepository.getReferenceById(id));
    }

    @Override
    public CategoryResponseDto save(CategoryDto categoryDto) {
        return categoryMapper
                .toResponseDto(
                        categoryRepository
                                .save(categoryMapper.toEntity(categoryDto))
                );
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryDto categoryDto) {
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    categoryMapper
                            .updateCategoryFromDto(
                                    categoryDto,
                                    existingCategory);
                    Category saved = categoryRepository.save(existingCategory);
                    return categoryMapper.toResponseDto(saved);
                }).orElseThrow(
                        () -> new EntityNotFoundException(
                                "Category not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
