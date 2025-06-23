package com.book.booksstore.service;

import com.book.booksstore.dto.BookDto;
import com.book.booksstore.dto.CreateBookRequestDto;
import com.book.booksstore.exception.EntityNotFoundException;
import com.book.booksstore.mappers.BookMapper;
import com.book.booksstore.model.Book;
import com.book.booksstore.repository.BookRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Override
    public BookDto save(final CreateBookRequestDto book) {
        Book bookModel = bookMapper.toBookModel(book);
        Book savedBook = bookRepository.save(bookModel);
        return bookMapper.toBookDto(savedBook);
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Book not found with ID: " + id
                ));
        return bookMapper.toBookDto(book);
    }

    @Override
    public Page<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toBookDto);
    }

    @Override
    public BookDto update(Long id, BookDto updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setCoverImage(updatedBook.getCoverImage());
            Book savedBook = bookRepository.save(existingBook);
            return bookMapper.toBookDto(savedBook);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

    @Override
    public boolean deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<BookDto> findByCategory(Long categoryId, Pageable pageable) {
        return bookRepository.findAllByCategoriesId(categoryId, pageable)
                .map(bookMapper::toBookDto);
    }
}
