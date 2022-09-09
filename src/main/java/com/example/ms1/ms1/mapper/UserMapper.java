package com.example.ms1.ms1.mapper;

import com.example.ms1.ms1.entity.User;
import com.example.ms1.ms1.entity.dto.UserDto;
import com.example.ms1.ms1.service.IdCreator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserMapper {
    private final IdCreator idCreator;

    public UserDto mapUserToDto(User user) {
        return new UserDto(user.getId(),
                user.getUserName(),
                user.getLastName(),
                user.getUserName(),
                user.getCreationData());
    }

    public User mapUserDtoToUser(UserDto userDto) {
        return new User(idCreator.createUserId(),
                userDto.getName(),
                userDto.getLastName(),
                userDto.getUserName(),
                LocalDate.now());
    }
}
