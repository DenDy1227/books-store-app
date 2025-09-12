package com.book.booksstore.repository;

import com.book.booksstore.model.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {
    Page<OrderItem> findByOrderId(Long orderId, Pageable pageable);

    java.util.Optional<OrderItem> findByIdAndOrderId(Long id, Long orderId);
}
