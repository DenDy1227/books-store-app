package com.book.booksstore.controller;

import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.CategoryRequestDto;
import com.book.booksstore.dto.CategoryResponseDto;
import com.book.booksstore.service.BookService;
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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final BookService bookService;

    @GetMapping
    public Page<CategoryResponseDto> findAll(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping(("/{categoryId}/books"))
    public Page<BookDto> getBookByCategoryId(
            @PathVariable
            @Valid
            Long categoryId,
            Pageable pageable) {
        return bookService.findByCategory(categoryId, pageable);
    }

    @Operation(
            summary = "Category creation.",
            description = "Adding new category.")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryRequestDto createCategory(
            @RequestBody
            @Valid
            CategoryResponseDto categoryResponseDto) {
        return categoryService.saveCategory(categoryResponseDto);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryRequestDto updateCategory(
            @RequestParam Long categoryId,
            @RequestBody
            @Valid
            CategoryResponseDto categoryResponseDto) {
        return categoryService.updateCategory(categoryId, categoryResponseDto);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategoryById(@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
