package com.book.booksstore.security;

import com.book.booksstore.dto.UserLoginRequestDto;
import com.book.booksstore.dto.UserLoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    public UserLoginResponseDto authenticate(
            UserLoginRequestDto userLoginRequestDto) {

        final Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userLoginRequestDto.getEmail(),
                                userLoginRequestDto.getPassword()));
        String token = jwtUtil.generateToken(authentication.getName());

        return new UserLoginResponseDto(token);
    }
}
