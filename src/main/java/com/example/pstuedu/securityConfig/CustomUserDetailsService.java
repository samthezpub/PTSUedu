package com.example.pstuedu.securityConfig;

import com.example.pstuedu.entity.User;
import com.example.pstuedu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.getUserByUsername(username);

        try {
            return user.map(CustomUserDetails::new)
                    .orElseThrow(() -> new RuntimeException(String.format("Пользователь %s не найден", username)));
        } catch (RuntimeException exception) {
            throw new RuntimeException();
        }
    }
}
