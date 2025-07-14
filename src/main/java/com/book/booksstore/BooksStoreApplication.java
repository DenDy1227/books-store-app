package com.book.booksstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.book.booksstore")
public class BooksStoreApplication {
    public static void main(final String[] args) {
        SpringApplication.run(BooksStoreApplication.class, args);
    }
}
