package com.htc.backend.dto;

import java.time.LocalDate;

public class ApplicationResponse {
    
    private Long appId;
    private Long seekerId;
    private Long jobId;
    private String status;
    private LocalDate appliedDate;
    
    public ApplicationResponse() {
    }
    
    public ApplicationResponse(Long appId, Long seekerId, Long jobId, 
                              String status, LocalDate appliedDate) {
        this.appId = appId;
        this.seekerId = seekerId;
        this.jobId = jobId;
        this.status = status;
        this.appliedDate = appliedDate;
    }
    
    public Long getAppId() {
        return appId;
    }
    
    public void setAppId(Long appId) {
        this.appId = appId;
    }
    
    public Long getSeekerId() {
        return seekerId;
    }
    
    public void setSeekerId(Long seekerId) {
        this.seekerId = seekerId;
    }
    
    public Long getJobId() {
        return jobId;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getAppliedDate() {
        return appliedDate;
    }
    
    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
}
