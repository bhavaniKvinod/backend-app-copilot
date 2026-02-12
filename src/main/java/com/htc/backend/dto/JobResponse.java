package com.htc.backend.dto;

import java.time.LocalDate;

public class JobResponse {
    
    private Long jobId;
    private Long employerUserId;
    private String title;
    private String description;
    private String jobType;
    private String requirements;
    private String salaryRange;
    private String status;
    private LocalDate postedDate;
    
    public JobResponse() {
    }
    
    public JobResponse(Long jobId, Long employerUserId, String title, String description,
                      String jobType, String requirements, String salaryRange, 
                      String status, LocalDate postedDate) {
        this.jobId = jobId;
        this.employerUserId = employerUserId;
        this.title = title;
        this.description = description;
        this.jobType = jobType;
        this.requirements = requirements;
        this.salaryRange = salaryRange;
        this.status = status;
        this.postedDate = postedDate;
    }
    
    public Long getJobId() {
        return jobId;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public Long getEmployerUserId() {
        return employerUserId;
    }
    
    public void setEmployerUserId(Long employerUserId) {
        this.employerUserId = employerUserId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getJobType() {
        return jobType;
    }
    
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    
    public String getRequirements() {
        return requirements;
    }
    
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    
    public String getSalaryRange() {
        return salaryRange;
    }
    
    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getPostedDate() {
        return postedDate;
    }
    
    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }
}
