package com.book.booksstore.service;

import com.book.booksstore.dto.CreateUserRequestDto;
import com.book.booksstore.dto.UserDto;
import com.book.booksstore.exception.RegistrationException;

public interface AuthService {
    UserDto register(CreateUserRequestDto user) throws RegistrationException;
}
