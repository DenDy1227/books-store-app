package com.book.booksstore.mappers;

import com.book.booksstore.dto.OrderItemResponseDto;
import com.book.booksstore.dto.OrderRequestDto;
import com.book.booksstore.dto.OrderResponseDto;
import com.book.booksstore.model.Order;
import com.book.booksstore.model.OrderItem;
import com.book.booksstore.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "orderItems", ignore = true)
    Order toEntity(OrderRequestDto dto);

    void updateEntity(OrderRequestDto dto, @MappingTarget Order order);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "orderItems", source = "orderItems")
    OrderResponseDto toResponseDto(Order order);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "bookTitle", source = "book.title")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    OrderItemResponseDto toItemResponseDto(OrderItem item);

    default Status mapStatus(String status) {
        return status == null ? null : Status.valueOf(status);
    }

    default String mapStatus(Status status) {
        return status == null ? null : status.name();
    }
}
