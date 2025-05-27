package com.book.booksstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Getter
    @Column(nullable = false)
    private String author;

    @Setter
    @Getter
    @Column(nullable = false, unique = true, name = "isbn")
    private String isbn;

    @Setter
    @Getter
    @Column(nullable = false)
    private BigDecimal price;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private String coverImage;
}
