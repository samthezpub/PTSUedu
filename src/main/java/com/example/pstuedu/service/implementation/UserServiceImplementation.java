package com.example.pstuedu.service.implementation;

import com.example.pstuedu.entity.User;
import com.example.pstuedu.exception.UserNotFoundException;
import com.example.pstuedu.repository.UserRepository;
import com.example.pstuedu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        // TODO createUser
        userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден!"));

        return user;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }
}
