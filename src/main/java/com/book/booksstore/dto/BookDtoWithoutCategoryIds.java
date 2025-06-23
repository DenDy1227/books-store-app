package com.book.booksstore.dto;

import java.math.BigDecimal;
import java.util.Set;

public class BookDtoWithoutCategoryIds {

    private Long id;

    private String title;

    private String author;

    private String isbn;

    private BigDecimal price;

    private String description;

    private String coverImage;

    private Set<CategoryDto> categories;
}
