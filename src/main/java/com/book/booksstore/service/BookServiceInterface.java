package com.book.booksstore.service;

import com.book.booksstore.model.Book;
import java.util.List;

public interface BookServiceInterface {
    Book save(Book nextBook);

    List findAll();
}
