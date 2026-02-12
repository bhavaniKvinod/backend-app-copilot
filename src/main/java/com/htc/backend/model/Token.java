package com.htc.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "token")
public class Token {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "userid")
    private Long userid;
    
    @Column(name = "jwttoken")
    private String jwtToken;
    
    @Column(name = "is_revoked")
    private Boolean isRevoked;
    
    @Column(name = "is_expired")
    private Boolean isExpired;
    
    // Constructors
    public Token() {
    }
    
    public Token(Long userid, String jwtToken, Boolean isRevoked, Boolean isExpired) {
        this.userid = userid;
        this.jwtToken = jwtToken;
        this.isRevoked = isRevoked;
        this.isExpired = isExpired;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserid() {
        return userid;
    }
    
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    
    public String getJwtToken() {
        return jwtToken;
    }
    
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    
    public Boolean getIsRevoked() {
        return isRevoked;
    }
    
    public void setIsRevoked(Boolean isRevoked) {
        this.isRevoked = isRevoked;
    }
    
    public Boolean getIsExpired() {
        return isExpired;
    }
    
    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }
    
    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", userid=" + userid +
                ", jwtToken='" + jwtToken + '\'' +
                ", isRevoked=" + isRevoked +
                ", isExpired=" + isExpired +
                '}';
    }
}
