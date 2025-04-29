package com.book.booksstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    public String title;
    @NotNull
    public String author;

    @Column(name = "isbn")
    public String isbn;

    @NotNull
    public BigDecimal price;
    public String description;
    public String coverImage;
}
