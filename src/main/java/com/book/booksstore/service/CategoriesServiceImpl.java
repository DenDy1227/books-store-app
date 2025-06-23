package com.book.booksstore.service;

import com.book.booksstore.dto.CategoryDto;
import com.book.booksstore.mappers.CategoryMapper;
import com.book.booksstore.model.Category;
import com.book.booksstore.repository.CategoryRepository;
import java.util.Optional;
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
    public CategoryDto getById(Long id) {
        return categoryMapper.toDto(categoryRepository.getReferenceById(id));
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryMapper
                .toDto(
                        categoryRepository
                                .save(categoryMapper.toEntity(categoryDto))
                );
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setName(categoryDto.getName());
            existingCategory.setDescription(categoryDto.getDescription());

            Category savedCategory = categoryRepository.save(existingCategory);
            return categoryMapper.toDto(savedCategory);
        } else {
            throw new RuntimeException("Category not found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
