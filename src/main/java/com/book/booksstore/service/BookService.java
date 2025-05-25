package com.book.booksstore.service;

import com.book.booksstore.model.Book;
import java.util.List;

/**
 * The interface Book service.
 */
public interface BookService {
    /**
     * Save book.
     *
     * @param nextBook the next book
     * @return the book
     */
    Book save(Book nextBook);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Book> findAll();
}
