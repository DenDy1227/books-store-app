package com.book.booksstore;

import com.book.booksstore.model.Book;
import com.book.booksstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksStoreApplication {
    public static void main(final String[] args) {
        SpringApplication.run(BooksStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BookService bookService) {
        return args -> {
            bookService.findAll();
            Book book1 = new Book();
            book1.setTitle("Book 1");
            book1.setAuthor("Author 1");
            book1.setIsbn("ISBN 1");
            book1.setPrice(BigDecimal.valueOf(100));
            bookService.save(book1);
            System.out.println("Alll books" + bookService.findAll());
        };
    }
}
