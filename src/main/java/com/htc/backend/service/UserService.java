package com.htc.backend.service;

import com.htc.backend.model.User;
import java.util.Optional;
import java.util.List;

public interface UserService {
    
    // CREATE
    /**
     * Save a new user
     * @param user the user to save
     * @return the saved user
     */
    User saveUser(User user);
    
    // READ
    /**
     * Get user by ID
     * @param userId the user's ID
     * @return Optional containing the user if found
     */
    Optional<User> getUserById(Long userId);
    
    /**
     * Get user by email
     * @param email the user's email
     * @return Optional containing the user if found
     */
    Optional<User> getUserByEmail(String email);
    
    /**
     * Get all users
     * @return List of all users
     */
    List<User> getAllUsers();
    
    /**
     * Get all users by role
     * @param role the user's role
     * @return List of users with the specified role
     */
    List<User> getUsersByRole(String role);
    
    /**
     * Get user by first and last name
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @return Optional containing the user if found
     */
    Optional<User> getUserByFirstAndLastName(String firstName, String lastName);
    
    // UPDATE
    /**
     * Update an existing user
     * @param userId the user's ID
     * @param user the updated user data
     * @return the updated user
     */
    User updateUser(Long userId, User user);
    
    // DELETE
    /**
     * Delete user by ID
     * @param userId the user's ID
     */
    void deleteUser(Long userId);
    
    /**
     * Delete all users
     */
    void deleteAllUsers();
    
    // UTILITY
    /**
     * Check if user exists by email
     * @param email the user's email
     * @return true if user exists, false otherwise
     */
    boolean userExists(String email);
    
    /**
     * Get total number of users
     * @return count of all users
     */
    long getTotalUserCount();
}
