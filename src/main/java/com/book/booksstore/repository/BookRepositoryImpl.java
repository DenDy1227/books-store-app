package com.book.booksstore.repository;

import com.book.booksstore.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import jakarta.persistence.PersistenceContext;

@Repository
public class BookRepositoryImpl implements BookRepository  {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Book save(Book book) {
        try {
            if (book.getId() == null) {
                entityManager.persist(book);
                return book;
            } else {
                return entityManager.merge(book);
            }
        } catch (Exception e) {
            // You can wrap it in a custom exception or just rethrow
            throw new DataAccessException("Failed to save book: " + book, e) {};
        }

    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }
}
