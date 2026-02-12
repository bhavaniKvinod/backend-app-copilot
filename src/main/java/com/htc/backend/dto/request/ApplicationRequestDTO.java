package com.htc.backend.dto.request;

public class ApplicationRequestDTO {
    
    private Long seekerId;
    private Long jobId;
    private String status;
    
    // Constructors
    public ApplicationRequestDTO() {
    }
    
    public ApplicationRequestDTO(Long seekerId, Long jobId, String status) {
        this.seekerId = seekerId;
        this.jobId = jobId;
        this.status = status;
    }
    
    // Getters and Setters
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
    
    @Override
    public String toString() {
        return "ApplicationRequestDTO{" +
                "seekerId=" + seekerId +
                ", jobId=" + jobId +
                ", status='" + status + '\'' +
                '}';
    }
}
