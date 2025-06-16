package com.book.booksstore.controller;

import com.book.booksstore.dto.CreateUserRequestDto;
import com.book.booksstore.dto.UserDto;
import com.book.booksstore.exception.RegistrationException;
import com.book.booksstore.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<UserDto> register(CreateUserRequestDto request)
            throws RegistrationException {
        UserDto user = authService.register(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
