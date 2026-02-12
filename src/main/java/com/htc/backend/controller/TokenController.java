package com.htc.backend.controller;

import com.htc.backend.model.Token;
import com.htc.backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tokens")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TokenController {
    
    @Autowired
    private TokenService tokenService;
    
    // CREATE
    @PostMapping
    public ResponseEntity<Token> createToken(@RequestBody Token token) {
        try {
            Token savedToken = tokenService.saveToken(token);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get all tokens
    @GetMapping
    public ResponseEntity<List<Token>> getAllTokens() {
        try {
            List<Token> tokens = tokenService.getAllTokens();
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by ID
    @GetMapping("/{tokenId}")
    public ResponseEntity<Token> getTokenById(@PathVariable Long tokenId) {
        try {
            Optional<Token> token = tokenService.getTokenById(tokenId);
            return token.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by JWT token
    @GetMapping("/jwt/{jwtToken}")
    public ResponseEntity<Token> getTokenByJwtToken(@PathVariable String jwtToken) {
        try {
            Optional<Token> token = tokenService.getTokenByJwtToken(jwtToken);
            return token.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by user ID
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Token>> getTokensByUserId(@PathVariable Long userid) {
        try {
            List<Token> tokens = tokenService.getTokensByUserId(userid);
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get active tokens
    @GetMapping("/active/all")
    public ResponseEntity<List<Token>> getActiveTokens() {
        try {
            List<Token> tokens = tokenService.getActiveTokens();
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get expired tokens
    @GetMapping("/expired/all")
    public ResponseEntity<List<Token>> getExpiredTokens() {
        try {
            List<Token> tokens = tokenService.getExpiredTokens();
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get revoked tokens
    @GetMapping("/revoked/all")
    public ResponseEntity<List<Token>> getRevokedTokens() {
        try {
            List<Token> tokens = tokenService.getRevokedTokens();
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get active tokens by user ID
    @GetMapping("/user/{userid}/active")
    public ResponseEntity<List<Token>> getActiveTokensByUserId(@PathVariable Long userid) {
        try {
            List<Token> tokens = tokenService.getActiveTokensByUserId(userid);
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE
    @PutMapping("/{tokenId}")
    public ResponseEntity<Token> updateToken(
            @PathVariable Long tokenId,
            @RequestBody Token token) {
        try {
            Token updatedToken = tokenService.updateToken(tokenId, token);
            return ResponseEntity.ok(updatedToken);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE - Revoke token
    @PutMapping("/{tokenId}/revoke")
    public ResponseEntity<Void> revokeToken(@PathVariable Long tokenId) {
        try {
            tokenService.revokeToken(tokenId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE - Expire token
    @PutMapping("/{tokenId}/expire")
    public ResponseEntity<Void> expireToken(@PathVariable Long tokenId) {
        try {
            tokenService.expireToken(tokenId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE
    @DeleteMapping("/{tokenId}")
    public ResponseEntity<Void> deleteToken(@PathVariable Long tokenId) {
        try {
            tokenService.deleteToken(tokenId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - All tokens
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTokens() {
        try {
            tokenService.deleteAllTokens();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - Expired tokens
    @DeleteMapping("/expired/all")
    public ResponseEntity<Void> deleteExpiredTokens() {
        try {
            tokenService.deleteExpiredTokens();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - Revoked tokens
    @DeleteMapping("/revoked/all")
    public ResponseEntity<Void> deleteRevokedTokens() {
        try {
            tokenService.deleteRevokedTokens();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Validate token
    @GetMapping("/validate/{jwtToken}")
    public ResponseEntity<Boolean> isValidToken(@PathVariable String jwtToken) {
        try {
            boolean isValid = tokenService.isValidToken(jwtToken);
            return ResponseEntity.ok(isValid);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Check if token exists
    @GetMapping("/exists/{tokenId}")
    public ResponseEntity<Boolean> tokenExists(@PathVariable Long tokenId) {
        try {
            boolean exists = tokenService.tokenExists(tokenId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get total count
    @GetMapping("/count/total")
    public ResponseEntity<Long> getTotalTokenCount() {
        try {
            long count = tokenService.getTotalTokenCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get active count
    @GetMapping("/count/active")
    public ResponseEntity<Long> getActiveTokenCount() {
        try {
            long count = tokenService.getActiveTokenCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
