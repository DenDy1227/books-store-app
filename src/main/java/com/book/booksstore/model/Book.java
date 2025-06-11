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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLDelete(sql = "UPDATE books SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted=false")
@Table(name = "books")
public class Book {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String title;

    @Setter
    @Getter
    @Column(nullable = false)
    private String author;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String isbn;

    @Setter
    @Getter
    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean isDeleted;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private String coverImage;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
