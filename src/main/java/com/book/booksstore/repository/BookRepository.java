package com.book.booksstore.repository;

import com.book.booksstore.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
}
