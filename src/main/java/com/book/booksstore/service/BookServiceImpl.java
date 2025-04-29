package com.book.booksstore.service;

import com.book.booksstore.model.Book;
import com.book.booksstore.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }
}
