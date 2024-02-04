package com.example.pstuedu.repository;

import com.example.pstuedu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUsername(String username);

}
