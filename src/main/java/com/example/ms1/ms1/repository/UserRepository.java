package com.example.ms1.ms1.repository;

import com.example.ms1.ms1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(int randomId);
}
