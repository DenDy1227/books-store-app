package com.book.booksstore.controller;

import com.book.booksstore.dto.OrderItemResponseDto;
import com.book.booksstore.dto.OrderRequestDto;
import com.book.booksstore.dto.OrderResponseDto;
import com.book.booksstore.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Order",
        description = "Endpoints for receiving orders info.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Page<OrderResponseDto> getOrders(Pageable pageable) {
        return orderService.getOrders(pageable);
    }

    @PostMapping
    public OrderResponseDto placeAnOrder(@Valid OrderRequestDto orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping
    public OrderResponseDto patchAnOrder(@Valid OrderRequestDto orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @GetMapping("{orderId}/items")
    public Page<OrderItemResponseDto> getOrderItems(
            @PathVariable Long orderId,
            Pageable pageable) {
        return orderService.getOrderItems(orderId, pageable);
    }

    @GetMapping("{orderId}/items/{itemId}")
    public OrderItemResponseDto getOrderItem(
            @PathVariable Long orderId,
            @PathVariable Long itemId) {
        return orderService.getOrderItem(orderId, itemId);
    }
}
