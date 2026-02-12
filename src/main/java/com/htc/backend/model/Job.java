package com.htc.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job")
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long jobId;
    
    @Column(name = "employer_user_id")
    private Long employerUserId;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "job_type")
    private String jobType;
    
    @Column(name = "requirements")
    private String requirements;
    
    @Column(name = "salary_range")
    private String salaryRange;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "posted_date")
    private LocalDate postedDate;
    
    // Constructors
    public Job() {
    }
    
    public Job(Long employerUserId, String title, String description, String jobType,
               String requirements, String salaryRange, String status) {
        this.employerUserId = employerUserId;
        this.title = title;
        this.description = description;
        this.jobType = jobType;
        this.requirements = requirements;
        this.salaryRange = salaryRange;
        this.status = status;
    }
    
    // Getters and Setters
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
    
    // JPA Lifecycle callback
    @PrePersist
    protected void onCreate() {
        if (postedDate == null) {
            postedDate = LocalDate.now();
        }
    }
    
    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", employerUserId=" + employerUserId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", jobType='" + jobType + '\'' +
                ", requirements='" + requirements + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", status='" + status + '\'' +
                ", postedDate=" + postedDate +
                '}';
    }
}
