package com.book.booksstore.repository;

import com.book.booksstore.dto.ShoppingCartResponseDto;
import com.book.booksstore.model.ShoppingCart;
import com.book.booksstore.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository
        extends JpaRepository<ShoppingCart, Long> {
    ShoppingCartResponseDto getShoppingCartById(Long id);
    
    Optional<ShoppingCart> findFirstByUserAndIsDeletedFalse(User user);
}
