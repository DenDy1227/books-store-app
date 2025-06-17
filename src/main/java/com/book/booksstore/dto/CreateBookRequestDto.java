package com.book.booksstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {

    @NotBlank(message = "Title can not be empty.")
    private String title;

    @NotBlank(message = "Author can not be empty.")
    private String author;

    @NotBlank(message = "ISBN can not be empty")
    private String isbn;

    @NotNull
    @PositiveOrZero(message = "Price can not be negative.")
    private BigDecimal price;

    private String description;

    private String coverImage;
}
