package com.example.pstuedu.service;

import com.example.pstuedu.entity.User;
import com.example.pstuedu.exception.UserNotFoundException;

public interface UserService {
    void createUser(User user);

    User findUserById(Long id) throws UserNotFoundException;

    void updateUser(User user);

    void deleteUser(Long user);
}
