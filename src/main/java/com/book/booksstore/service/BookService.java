package com.book.booksstore.service;

import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto nextBook);

    BookDto findById(Long id);

    Page<BookDto> findAll(Pageable pageable);

    BookDto update(Long id, BookDto updatedBook);

    boolean deleteBook(Long id);
}
