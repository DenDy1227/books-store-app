package com.book.booksstore.repository;

import com.book.booksstore.model.Book;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * The type Book repository.
 */
@Repository
public class BookRepositoryImpl implements BookRepository {
    /**
     * The Hibernate SessionFactory used to open and manage database sessions.
     */
    private final SessionFactory sessionFactory;

    /**
     * Instantiates a new Book repository.
     *
     * @param sessionFactory the session factory
     */
    @Autowired
    public BookRepositoryImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Save a new Book repository.
     *
     * @param book the book to save
     */
    @Override
    @Transactional
    public Book save(final Book book) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataAccessException("Failed to save book: " + book, e) {
            };
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return book;
    }

    /**
     * Return all books.

     */
    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Book", Book.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all books", e);
        }
    }
}
