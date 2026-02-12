package com.htc.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "application")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long appId;
    
    @Column(name = "seeker_id")
    private Long seekerId;
    
    @Column(name = "job_id")
    private Long jobId;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "applied_date")
    private LocalDate appliedDate;
    
    // Constructors
    public Application() {
    }
    
    public Application(Long seekerId, Long jobId, String status) {
        this.seekerId = seekerId;
        this.jobId = jobId;
        this.status = status;
    }
    
    // Getters and Setters
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
    
    // JPA Lifecycle callback
    @PrePersist
    protected void onCreate() {
        if (appliedDate == null) {
            appliedDate = LocalDate.now();
        }
    }
    
    @Override
    public String toString() {
        return "Application{" +
                "appId=" + appId +
                ", seekerId=" + seekerId +
                ", jobId=" + jobId +
                ", status='" + status + '\'' +
                ", appliedDate=" + appliedDate +
                '}';
    }
}
