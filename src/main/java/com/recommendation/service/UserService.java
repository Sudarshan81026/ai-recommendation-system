package com.recommendation.service;

import com.recommendation.model.User;
import com.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        // Hash password before saving new or edited user
        if (user.getId() == null || isPasswordPlainText(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void deleteUsers(List<Integer> userIds) {
        userIds.forEach(this::deleteUser);
    }

    // Helper: Check password format (simple example, you may want a more robust check)
    private boolean isPasswordPlainText(String password) {
        return !password.startsWith("$2a$"); // BCrypt hash usually starts this way
    }
}
