package com.book.booksstore.service;

import com.book.booksstore.dto.OrderItemResponseDto;
import com.book.booksstore.dto.OrderRequestDto;
import com.book.booksstore.dto.OrderResponseDto;
import com.book.booksstore.mappers.OrderMapper;
import com.book.booksstore.model.Order;
import com.book.booksstore.model.OrderItem;
import com.book.booksstore.repository.OrderItemsRepository;
import com.book.booksstore.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrdersRepository ordersRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final OrderMapper orderMapper;

    @Override
    public Page<OrderResponseDto> getOrders(Pageable pageable) {
        return ordersRepository.findAll(pageable)
                .map(orderMapper::toResponseDto);
    }

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequest) {
        Order order = orderMapper.toEntity(orderRequest);
        Order saved = ordersRepository.save(order);
        return orderMapper.toResponseDto(saved);
    }

    @Override
    public OrderResponseDto patchOrder(OrderRequestDto orderRequest) {
        Order existing = ordersRepository.findById(orderRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Order not found: " + orderRequest.getId()));
        orderMapper.updateEntity(orderRequest, existing);
        Order updated = ordersRepository.save(existing);
        return orderMapper.toResponseDto(updated);
    }

    @Override
    @Transactional
    public Page<OrderItemResponseDto> getOrderItems(
            Long orderId, Pageable pageable) {
        return orderItemsRepository.findByOrderId(orderId, pageable)
                .map(orderMapper::toItemResponseDto);
    }

    @Override
    public OrderItemResponseDto getOrderItem(Long orderId, Long itemId) {
        OrderItem item = orderItemsRepository
                .findByIdAndOrderId(itemId, orderId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "OrderItem not found: " + itemId));
        return orderMapper.toItemResponseDto(item);
    }
}
