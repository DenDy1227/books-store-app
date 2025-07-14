package com.book.booksstore.repository;

import com.book.booksstore.model.CartItem;
import com.book.booksstore.model.ShoppingCart;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByShoppingCartAndBookId(
            ShoppingCart cart,
            Long bookId);
}
