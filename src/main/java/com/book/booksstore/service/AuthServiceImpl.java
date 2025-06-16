package com.book.booksstore.service;

import com.book.booksstore.dto.CreateUserRequestDto;
import com.book.booksstore.dto.UserDto;
import com.book.booksstore.exception.RegistrationException;
import com.book.booksstore.mappers.UserMapper;
import com.book.booksstore.model.User;
import com.book.booksstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto register(CreateUserRequestDto request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RegistrationException(
                    "User already exists. EMAIL: "
                            + request.getEmail());
        }
        User user = userMapper.toUserModel(request);
        User saved = userRepository.save(user);
        return userMapper.toUserDto(saved);
    }
}
