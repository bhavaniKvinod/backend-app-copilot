package com.htc.backend.service.impl;

import com.htc.backend.model.User;
import com.htc.backend.repository.UserRepository;
import com.htc.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
    
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }
    
    @Override
    public Optional<User> getUserByFirstAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    
    @Override
    public User updateUser(Long userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setUserId(userId);
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found with ID: " + userId);
    }
    
    @Override
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
    
    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
    
    @Override
    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    @Override
    public long getTotalUserCount() {
        return userRepository.count();
    }
}
