package com.htc.backend.dto.request;

public class TokenRequestDTO {
    
    private Long userid;
    private String jwtToken;
    
    // Constructors
    public TokenRequestDTO() {
    }
    
    public TokenRequestDTO(Long userid, String jwtToken) {
        this.userid = userid;
        this.jwtToken = jwtToken;
    }
    
    // Getters and Setters
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
    
    @Override
    public String toString() {
        return "TokenRequestDTO{" +
                "userid=" + userid +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
