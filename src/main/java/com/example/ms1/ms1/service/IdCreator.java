package com.example.ms1.ms1.service;

import com.example.ms1.ms1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class IdCreator {
    private final UserRepository userRepository;
    private Random random = new Random();

    public int createUserId() {
        int randomId = random.nextInt(899999) + 100000;
        if(findDuplicate(randomId)){
            createUserId();
        }
        return randomId;
    }

    private boolean findDuplicate(int id) {
        return userRepository.existsById(id);
    }
}
