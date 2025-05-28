package com.book.booksstore;

import com.book.booksstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksStoreApplication {

    @Autowired
    private BookService bookService;

    public static void main(final String[] args) {
        SpringApplication.run(BooksStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            bookService.findAll();
        };
    }
}
