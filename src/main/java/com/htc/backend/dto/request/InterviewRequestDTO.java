package com.htc.backend.dto.request;

import java.time.LocalDate;

public class InterviewRequestDTO {
    
    private Long appId;
    private LocalDate schedDate;
    private String mode;
    private String result;
    private String feedback;
    
    // Constructors
    public InterviewRequestDTO() {
    }
    
    public InterviewRequestDTO(Long appId, LocalDate schedDate, String mode, String result, String feedback) {
        this.appId = appId;
        this.schedDate = schedDate;
        this.mode = mode;
        this.result = result;
        this.feedback = feedback;
    }
    
    // Getters and Setters
    public Long getAppId() {
        return appId;
    }
    
    public void setAppId(Long appId) {
        this.appId = appId;
    }
    
    public LocalDate getSchedDate() {
        return schedDate;
    }
    
    public void setSchedDate(LocalDate schedDate) {
        this.schedDate = schedDate;
    }
    
    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    public String getResult() {
        return result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
    
    public String getFeedback() {
        return feedback;
    }
    
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    @Override
    public String toString() {
        return "InterviewRequestDTO{" +
                "appId=" + appId +
                ", schedDate=" + schedDate +
                ", mode='" + mode + '\'' +
                ", result='" + result + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
