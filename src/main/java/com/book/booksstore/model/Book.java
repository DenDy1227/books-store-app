package com.book.booksstore.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLDelete(sql = "UPDATE books SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted=false")
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean isDeleted;

    @ManyToOne
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Long> categories = new HashSet<>();

    private String description;

    private String coverImage;
}
