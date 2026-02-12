package com.htc.backend.repository;

import com.htc.backend.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    
    /**
     * Find token by JWT token string
     * @param jwtToken the JWT token
     * @return Optional containing the token if found
     */
    Optional<Token> findByJwtToken(String jwtToken);
    
    /**
     * Find all tokens by user ID
     * @param userid the user's ID
     * @return List of tokens for the user
     */
    List<Token> findByUserid(Long userid);
    
    /**
     * Find all active (non-expired, non-revoked) tokens
     * @return List of active tokens
     */
    @Query("SELECT t FROM Token t WHERE t.isExpired = false AND t.isRevoked = false")
    List<Token> findActiveTokens();
    
    /**
     * Find all expired tokens
     * @return List of expired tokens
     */
    List<Token> findByIsExpiredTrue();
    
    /**
     * Find all revoked tokens
     * @return List of revoked tokens
     */
    List<Token> findByIsRevokedTrue();
    
    /**
     * Find active tokens by user ID
     * @param userid the user's ID
     * @return List of active tokens for the user
     */
    @Query("SELECT t FROM Token t WHERE t.userid = :userid AND t.isExpired = false AND t.isRevoked = false")
    List<Token> findActiveTokensByUserId(@Param("userid") Long userid);
    
    /**
     * Check if a token is valid (not expired and not revoked)
     * @param jwtToken the JWT token
     * @return true if token is valid, false otherwise
     */
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Token t WHERE t.jwtToken = :jwtToken AND t.isExpired = false AND t.isRevoked = false")
    boolean isValidToken(@Param("jwtToken") String jwtToken);
}
