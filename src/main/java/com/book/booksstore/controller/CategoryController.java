package com.book.booksstore.controller;

import com.book.booksstore.dto.CategoryDto;
import com.book.booksstore.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Book categories",
        description = "Endpoints for managing book categories.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public Page<CategoryDto> findAll(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @Operation(
            summary = "Category creation.",
            description = "Adding new category.")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto createCategory(
            @RequestBody
            @Valid
            CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto updateCategory(
            @RequestParam Long categoryId,
            @RequestBody
            @Valid
            CategoryDto categoryDto) {
        return categoryService.update(categoryId, categoryDto);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategoryById(@RequestBody @Valid Long categoryId) {
        categoryService.deleteById(categoryId);
    }
}
