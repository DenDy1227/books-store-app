package com.book.booksstore.repository;

import com.book.booksstore.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> existsByEmail(String email);

}
