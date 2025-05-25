package com.book.booksstore.repository;

import com.book.booksstore.model.Book;
import java.util.List;

/**
 * The interface Book repository.
 */
public interface BookRepository {
    /**
     * Save book.
     *
     * @param book the book
     * @return the book
     */
    Book save(Book book);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Book> findAll();
}
