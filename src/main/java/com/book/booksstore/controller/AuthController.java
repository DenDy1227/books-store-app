package com.book.booksstore.controller;

import com.book.booksstore.dto.CreateUserRequestDto;
import com.book.booksstore.dto.UserDto;
import com.book.booksstore.exception.RegistrationException;
import com.book.booksstore.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth api", description = "Endpoints for authentication.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "User registration.", description = "Adding new user.")
    @PostMapping("/registration")
    public ResponseEntity<UserDto> register(
            @RequestBody
            @Valid
            CreateUserRequestDto request)
            throws RegistrationException {
        UserDto user = authService.register(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
