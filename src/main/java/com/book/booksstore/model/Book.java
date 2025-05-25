package com.book.booksstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * The type Book.
 */
@Entity
@Table(name = "books")
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Title.
     */
    @Column(nullable = false)
    public String title;

    /**
     * The Author.
     */
    @Column(nullable = false)
    public String author;

    /**
     * The Isbn.
     */
    @Column(name = "isbn")
    public String isbn;

    /**
     * The Price.
     */
    @Column(nullable = false)
    public BigDecimal price;
    /**
     * The Description.
     */
    public String description;
    /**
     * The Cover image.
     */
    public String coverImage;
}
