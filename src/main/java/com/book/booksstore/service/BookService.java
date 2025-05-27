package com.book.booksstore.service;

import com.book.booksstore.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book nextBook);

    List<Book> findAll();
}
