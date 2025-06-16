package com.book.booksstore.service;

import com.book.booksstore.dto.CreateUserRequestDto;
import com.book.booksstore.dto.UserDto;

public interface AuthService {

    UserDto register(CreateUserRequestDto user);
}
