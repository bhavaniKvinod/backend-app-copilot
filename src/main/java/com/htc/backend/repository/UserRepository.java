package com.htc.backend.repository;

import com.htc.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Find user by email
     * @param email the user's email
     * @return Optional containing the user if found
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Find all users by role
     * @param role the user's role (EMPLOYER or JOB_SEEKER)
     * @return List of users with the specified role
     */
    List<User> findByRole(String role);
    
    /**
     * Find user by first and last name
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @return Optional containing the user if found
     */
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
    
    /**
     * Check if a user exists by email
     * @param email the user's email
     * @return true if user exists, false otherwise
     */
    boolean existsByEmail(String email);
}
