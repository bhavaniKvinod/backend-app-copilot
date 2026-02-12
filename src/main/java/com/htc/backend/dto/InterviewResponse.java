package com.htc.backend.dto;

import java.time.LocalDate;

public class InterviewResponse {
    
    private Long interviewId;
    private Long appId;
    private LocalDate schedDate;
    private String mode;
    private String result;
    private String feedback;
    
    public InterviewResponse() {
    }
    
    public InterviewResponse(Long interviewId, Long appId, LocalDate schedDate, 
                            String mode, String result, String feedback) {
        this.interviewId = interviewId;
        this.appId = appId;
        this.schedDate = schedDate;
        this.mode = mode;
        this.result = result;
        this.feedback = feedback;
    }
    
    public Long getInterviewId() {
        return interviewId;
    }
    
    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }
    
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
}
