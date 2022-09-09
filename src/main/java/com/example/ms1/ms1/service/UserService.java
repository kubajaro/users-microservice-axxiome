package com.example.ms1.ms1.service;

import com.example.ms1.ms1.entity.User;
import com.example.ms1.ms1.entity.dto.UserDto;
import com.example.ms1.ms1.mapper.UserMapper;
import com.example.ms1.ms1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.mapUserToDto(user))
                .collect(Collectors.toList());
    }

    public UserDto saveUser(UserDto userToSave) {
        User savedUser = userRepository.save(userMapper.mapUserDtoToUser(userToSave));
        UserDto savedUserDto = userMapper.mapUserToDto(savedUser);
        return savedUserDto;
    }
}
