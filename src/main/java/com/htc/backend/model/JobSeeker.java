package com.htc.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "job_seeker")
@DiscriminatorValue("JOB_SEEKER")
public class JobSeeker extends User {
    
    @Column(name = "skills")
    private String skills;
    
    @Column(name = "exp_years")
    private Integer expYears;
    
    @Column(name = "resume_url")
    private String resumeUrl;
    
    // Constructors
    public JobSeeker() {
    }
    
    public JobSeeker(String firstName, String lastName, String email, String password,
                     String address, String skills, Integer expYears, String resumeUrl) {
        super(firstName, lastName, email, password, address, "JOB_SEEKER");
        this.skills = skills;
        this.expYears = expYears;
        this.resumeUrl = resumeUrl;
    }
    
    // Getters and Setters
    public String getSkills() {
        return skills;
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public Integer getExpYears() {
        return expYears;
    }
    
    public void setExpYears(Integer expYears) {
        this.expYears = expYears;
    }
    
    public String getResumeUrl() {
        return resumeUrl;
    }
    
    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
    
    @Override
    public String toString() {
        return "JobSeeker{" +
                "skills='" + skills + '\'' +
                ", expYears=" + expYears +
                ", resumeUrl='" + resumeUrl + '\'' +
                ", " + super.toString() +
                '}';
    }
}
