package com.htc.backend.service.impl;

import com.htc.backend.exception.ResourceNotFoundException;
import com.htc.backend.model.Token;
import com.htc.backend.repository.TokenRepository;
import com.htc.backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {
    
    @Autowired
    private TokenRepository tokenRepository;
    
    @Override
    public Token saveToken(Token token) {
        return tokenRepository.save(token);
    }
    
    @Override
    public Optional<Token> getTokenById(Long tokenId) {
        return tokenRepository.findById(tokenId);
    }
    
    @Override
    public Optional<Token> getTokenByJwtToken(String jwtToken) {
        return tokenRepository.findByJwtToken(jwtToken);
    }
    
    @Override
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }
    
    @Override
    public List<Token> getTokensByUserId(Long userid) {
        return tokenRepository.findByUserid(userid);
    }
    
    @Override
    public List<Token> getActiveTokens() {
        return tokenRepository.findActiveTokens();
    }
    
    @Override
    public List<Token> getExpiredTokens() {
        return tokenRepository.findByIsExpiredTrue();
    }
    
    @Override
    public List<Token> getRevokedTokens() {
        return tokenRepository.findByIsRevokedTrue();
    }
    
    @Override
    public List<Token> getActiveTokensByUserId(Long userid) {
        return tokenRepository.findActiveTokensByUserId(userid);
    }
    
    @Override
    public Token updateToken(Long tokenId, Token token) {
        if (tokenRepository.existsById(tokenId)) {
            token.setId(tokenId);
            return tokenRepository.save(token);
        }
        throw new ResourceNotFoundException("Token", "tokenId", tokenId);
    }
    
    @Override
    public void revokeToken(Long tokenId) {
        Optional<Token> token = tokenRepository.findById(tokenId);
        if (token.isPresent()) {
            Token t = token.get();
            t.setIsRevoked(true);
            tokenRepository.save(t);
        } else {
            throw new ResourceNotFoundException("Token", "tokenId", tokenId);
        }
    }
    
    @Override
    public void expireToken(Long tokenId) {
        Optional<Token> token = tokenRepository.findById(tokenId);
        if (token.isPresent()) {
            Token t = token.get();
            t.setIsExpired(true);
            tokenRepository.save(t);
        } else {
            throw new ResourceNotFoundException("Token", "tokenId", tokenId);
        }
    }
    
    @Override
    public void deleteToken(Long tokenId) {
        if (tokenRepository.existsById(tokenId)) {
            tokenRepository.deleteById(tokenId);
        } else {
            throw new ResourceNotFoundException("Token", "tokenId", tokenId);
        }
    }
    
    @Override
    public void deleteAllTokens() {
        tokenRepository.deleteAll();
    }
    
    @Override
    public void deleteExpiredTokens() {
        List<Token> expiredTokens = tokenRepository.findByIsExpiredTrue();
        tokenRepository.deleteAll(expiredTokens);
    }
    
    @Override
    public void deleteRevokedTokens() {
        List<Token> revokedTokens = tokenRepository.findByIsRevokedTrue();
        tokenRepository.deleteAll(revokedTokens);
    }
    
    @Override
    public boolean isValidToken(String jwtToken) {
        return tokenRepository.isValidToken(jwtToken);
    }
    
    @Override
    public boolean tokenExists(Long tokenId) {
        return tokenRepository.existsById(tokenId);
    }
    
    @Override
    public long getTotalTokenCount() {
        return tokenRepository.count();
    }
    
    @Override
    public long getActiveTokenCount() {
        return tokenRepository.findActiveTokens().size();
    }
}
