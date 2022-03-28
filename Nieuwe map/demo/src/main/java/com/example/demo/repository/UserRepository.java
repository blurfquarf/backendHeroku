package com.example.demo.repository;

import com.example.demo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //hoe opgeslagen in databank
public interface UserRepository extends
        JpaRepository<User, Long> {

    User findByEmail(String email);
    
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    @Override
    void delete(User user);
}