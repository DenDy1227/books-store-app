package com.book.booksstore.service;

import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.CreateBookRequestDto;
import com.book.booksstore.exception.EntityNotFoundException;
import com.book.booksstore.mappers.BookMapper;
import com.book.booksstore.model.Book;
import com.book.booksstore.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Override
    public BookDto save(final CreateBookRequestDto book) {
        Book bookModel = bookMapper.toBookModel(book);
        return bookMapper.toBookDto(bookRepository.save(bookModel));
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Book not found by requested ID:" + id
                )
        );

        return bookMapper.toBookDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> allBooks = bookRepository.findAll();
        return allBooks
                .stream()
                .map(bookMapper::toBookDto)
                .toList();
    }
}
