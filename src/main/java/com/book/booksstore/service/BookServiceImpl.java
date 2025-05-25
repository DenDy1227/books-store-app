package com.book.booksstore.service;

import com.book.booksstore.model.Book;
import com.book.booksstore.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Book service.
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    /**
     * The Book service repository.
     */
    private final BookRepository bookRepository;

    /**
     * Save book.
     */
    @Override
    public Book save(final Book book) {
        return bookRepository.save(book);
    }

    /**
     * Get all books .
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
