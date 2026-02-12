package com.htc.backend.service;

import com.htc.backend.model.Token;
import java.util.Optional;
import java.util.List;

public interface TokenService {
    
    // CREATE
    /**
     * Save a new token
     * @param token the token to save
     * @return the saved token
     */
    Token saveToken(Token token);
    
    // READ
    /**
     * Get token by ID
     * @param tokenId the token's ID
     * @return Optional containing the token if found
     */
    Optional<Token> getTokenById(Long tokenId);
    
    /**
     * Get token by JWT token string
     * @param jwtToken the JWT token
     * @return Optional containing the token if found
     */
    Optional<Token> getTokenByJwtToken(String jwtToken);
    
    /**
     * Get all tokens
     * @return List of all tokens
     */
    List<Token> getAllTokens();
    
    /**
     * Get all tokens for a user
     * @param userid the user's ID
     * @return List of tokens for the user
     */
    List<Token> getTokensByUserId(Long userid);
    
    /**
     * Get all active (non-expired, non-revoked) tokens
     * @return List of active tokens
     */
    List<Token> getActiveTokens();
    
    /**
     * Get all expired tokens
     * @return List of expired tokens
     */
    List<Token> getExpiredTokens();
    
    /**
     * Get all revoked tokens
     * @return List of revoked tokens
     */
    List<Token> getRevokedTokens();
    
    /**
     * Get active tokens for a specific user
     * @param userid the user's ID
     * @return List of active tokens for the user
     */
    List<Token> getActiveTokensByUserId(Long userid);
    
    // UPDATE
    /**
     * Update an existing token
     * @param tokenId the token's ID
     * @param token the updated token data
     * @return the updated token
     */
    Token updateToken(Long tokenId, Token token);
    
    /**
     * Revoke a token
     * @param tokenId the token's ID
     */
    void revokeToken(Long tokenId);
    
    /**
     * Mark token as expired
     * @param tokenId the token's ID
     */
    void expireToken(Long tokenId);
    
    // DELETE
    /**
     * Delete token by ID
     * @param tokenId the token's ID
     */
    void deleteToken(Long tokenId);
    
    /**
     * Delete all tokens
     */
    void deleteAllTokens();
    
    /**
     * Delete all expired tokens
     */
    void deleteExpiredTokens();
    
    /**
     * Delete all revoked tokens
     */
    void deleteRevokedTokens();
    
    // UTILITY
    /**
     * Check if token is valid (not expired and not revoked)
     * @param jwtToken the JWT token
     * @return true if token is valid, false otherwise
     */
    boolean isValidToken(String jwtToken);
    
    /**
     * Check if token exists
     * @param tokenId the token's ID
     * @return true if token exists, false otherwise
     */
    boolean tokenExists(Long tokenId);
    
    /**
     * Get total number of tokens
     * @return count of all tokens
     */
    long getTotalTokenCount();
    
    /**
     * Get total number of active tokens
     * @return count of active tokens
     */
    long getActiveTokenCount();
}
