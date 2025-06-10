package com.book.booksstore.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {

    @NotNull(message = "Title can not be empty.")
    @Size(
            min = 1,
            max = 255,
            message = "Title size should be between 1 and 255 characters.")
    private String title;

    @NotNull(message = "Author can not be empty.")
    @Size(
            min = 1,
            max = 255,
            message = "Author name size should be between 1 and 255 characters")
    private String author;

    @NotNull
    @Pattern(
            regexp = "\\d{10} | \\d{13}",
            message = "ISBN can be 10 or 13 digits.")
    private String isbn;

    @NotNull
    @DecimalMin(
            value = "0.0",
            inclusive = true,
            message = "Price can not be negative.")
    private BigDecimal price;

    @NotNull
    @Size(
            min = 10,
            message = "Description must be 10 characters long.")
    private String description;

    @NotNull
    @Pattern(
            regexp = "^(http|https):\\.*",
            message = "Cover image should be valid URL.")
    private String coverImage;
}
