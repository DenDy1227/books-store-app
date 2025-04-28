package com.book.booksstore.service;

import com.book.booksstore.model.Book;
import com.book.booksstore.repository.BookRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BookServiceInterface {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book save(Book nextBook) {
        return bookRepo.save(nextBook);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }
}
