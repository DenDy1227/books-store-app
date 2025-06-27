package com.book.booksstore.service;

import com.book.booksstore.dto.OrderItemResponseDto;
import com.book.booksstore.dto.OrderRequestDto;
import com.book.booksstore.dto.OrderResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    Page<OrderResponseDto> getOrders(Pageable pageable);

    OrderResponseDto placeOrder(OrderRequestDto orderRequest);

    OrderResponseDto patchOrder(OrderRequestDto orderRequest);

    Page<OrderItemResponseDto> getOrderItems(Long orderId, Pageable pageable);

    OrderItemResponseDto getOrderItem(Long orderId, Long itemId);
}
