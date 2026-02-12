package com.htc.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "interview")
public class Interview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private Long interviewId;
    
    @Column(name = "app_id")
    private Long appId;
    
    @Column(name = "sched_date")
    private LocalDate schedDate;
    
    @Column(name = "mode")
    private String mode;
    
    @Column(name = "result")
    private String result;
    
    @Column(name = "feedback")
    private String feedback;
    
    // Constructors
    public Interview() {
    }
    
    public Interview(Long appId, LocalDate schedDate, String mode, String result, String feedback) {
        this.appId = appId;
        this.schedDate = schedDate;
        this.mode = mode;
        this.result = result;
        this.feedback = feedback;
    }
    
    // Getters and Setters
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
    
    @Override
    public String toString() {
        return "Interview{" +
                "interviewId=" + interviewId +
                ", appId=" + appId +
                ", schedDate=" + schedDate +
                ", mode='" + mode + '\'' +
                ", result='" + result + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
