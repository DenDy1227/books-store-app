package com.book.booksstore.mappers;

import com.book.booksstore.dto.CreateUserRequestDto;
import com.book.booksstore.dto.UserDto;
import com.book.booksstore.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    User toUserModel(CreateUserRequestDto createBookRequestDto);
}
