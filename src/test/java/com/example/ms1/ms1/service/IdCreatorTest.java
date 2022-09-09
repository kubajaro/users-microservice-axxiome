package com.example.ms1.ms1.service;

import com.example.ms1.ms1.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IdCreatorTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    IdCreator idCreator;

    @Test
    @DisplayName("method createId should create two unique values")
    void createId_testUniqueValues() {
        //given
        when(userRepository.existsById(anyInt())).thenReturn(false);

        //when
        int firstId = idCreator.createUserId();
        int secondId = idCreator.createUserId();

        //then
        assertNotEquals(firstId, secondId);
    }

    @Test
    @DisplayName("method creates id which already exists and reruns itself")
    void createId_idAlreadyExists() {
        //given
        when(userRepository.existsById(anyInt())).thenReturn(true).thenReturn(false);

        //when
        int createdId = idCreator.createUserId();

        //then
        verify(userRepository, times(2)).existsById(anyInt());
    }
}