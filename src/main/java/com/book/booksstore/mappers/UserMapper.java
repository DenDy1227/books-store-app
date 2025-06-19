package com.book.booksstore.mappers;

import com.book.booksstore.config.MapperConfig;
import com.book.booksstore.dto.CreateUserRequestDto;
import com.book.booksstore.dto.UserDto;
import com.book.booksstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toUserDto(User user);

    User toUserModel(CreateUserRequestDto createBookRequestDto);
}
