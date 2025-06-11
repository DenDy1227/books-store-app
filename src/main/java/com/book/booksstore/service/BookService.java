package com.book.booksstore.service;

import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto nextBook);

    BookDto findById(Long id);

    List<BookDto> findAll();
    
    BookDto update(Long id, BookDto updatedBook);

    boolean deleteBook(Long id);
}
