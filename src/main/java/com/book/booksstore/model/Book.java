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

/**
 * The type Book.
 */
@Entity
@Table(name = "books")
@Setter
@Getter
public class Book {
    /**
     * Book id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Title.
     */
    @Column(nullable = false)
    private String title;

    /**
     * The Author.
     */
    @Column(nullable = false)
    private String author;

    /**
     * The Isbn.
     */
    @Column(name = "isbn")
    private String isbn;

    /**
     * The Price.
     */
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * The Description.
     */
    private String description;

    /**
     * The Cover image.
     */
    private String coverImage;

    /**
     * Gets cover image.
     *
     * @return the cover image
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * Sets cover image.
     *
     * @param bookCoverImage the cover image
     */
    public void setCoverImage(final String bookCoverImage) {
        this.coverImage = bookCoverImage;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param bookTitle the title
     */
    public void setTitle(final String bookTitle) {
        this.title = bookTitle;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param bookDescription the description
     */
    public void setDescription(final String bookDescription) {
        this.description = bookDescription;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param bookPrice the price
     */
    public void setPrice(final BigDecimal bookPrice) {
        this.price = bookPrice;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param isbnNumber the isbn
     */
    public void setIsbn(final String isbnNumber) {
        this.isbn = isbnNumber;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param authorOfBook the author
     */
    public void setAuthor(final String authorOfBook) {
        this.author = authorOfBook;
    }
}

