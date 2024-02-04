package com.example.pstuedu.repository;

import com.example.pstuedu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
