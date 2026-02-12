package com.htc.backend.dto;

public class TokenResponse {
    
    private Long id;
    private Long userid;
    private Boolean isRevoked;
    private Boolean isExpired;
    
    public TokenResponse() {
    }
    
    public TokenResponse(Long id, Long userid, Boolean isRevoked, Boolean isExpired) {
        this.id = id;
        this.userid = userid;
        this.isRevoked = isRevoked;
        this.isExpired = isExpired;
    }
    
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
}
