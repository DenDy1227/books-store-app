package com.book.booksstore.dto;

import com.book.booksstore.model.OrderItem;
import com.book.booksstore.model.Status;
import com.book.booksstore.model.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private Long id;
    private String shippingAddress;
    private Status status;
    private User user;
    private BigDecimal total;
    private LocalDateTime orderDate;
    private Set<OrderItem> orderItems;
}
