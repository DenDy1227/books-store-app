package com.book.booksstore.repository;

import com.book.booksstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAllByCategoriesId(Long categoryId, Pageable pageable);
}
