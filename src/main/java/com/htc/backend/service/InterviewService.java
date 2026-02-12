package com.htc.backend.service;

import com.htc.backend.model.Interview;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface InterviewService {
    
    // CREATE
    /**
     * Save a new interview
     * @param interview the interview to save
     * @return the saved interview
     */
    Interview saveInterview(Interview interview);
    
    // READ
    /**
     * Get interview by ID
     * @param interviewId the interview's ID
     * @return Optional containing the interview if found
     */
    Optional<Interview> getInterviewById(Long interviewId);
    
    /**
     * Get all interviews
     * @return List of all interviews
     */
    List<Interview> getAllInterviews();
    
    /**
     * Get interviews by application
     * @param appId the application ID
     * @return List of interviews for the application
     */
    List<Interview> getInterviewsByApplication(Long appId);
    
    /**
     * Get interviews by interview mode
     * @param mode the interview mode (In-person, Video, Phone, etc.)
     * @return List of interviews with the specified mode
     */
    List<Interview> getInterviewsByMode(String mode);
    
    /**
     * Get interviews by result
     * @param result the interview result (Pass, Fail, Pending, etc.)
     * @return List of interviews with the specified result
     */
    List<Interview> getInterviewsByResult(String result);
    
    /**
     * Get interviews scheduled on a specific date
     * @param schedDate the scheduled date
     * @return List of interviews scheduled on the date
     */
    List<Interview> getInterviewsBySchedDate(LocalDate schedDate);
    
    /**
     * Get interviews scheduled after a specific date
     * @param schedDate the date to search from
     * @return List of interviews scheduled after the specified date
     */
    List<Interview> getUpcomingInterviews(LocalDate schedDate);
    
    /**
     * Get interviews scheduled within a date range
     * @param startDate the start date
     * @param endDate the end date
     * @return List of interviews scheduled between the dates
     */
    List<Interview> getInterviewsByDateRange(LocalDate startDate, LocalDate endDate);
    
    /**
     * Get all pending interviews
     * @return List of interviews with no result (pending)
     */
    List<Interview> getPendingInterviews();
    
    /**
     * Get interviews with feedback
     * @return List of interviews with feedback provided
     */
    List<Interview> getInterviewsWithFeedback();
    
    // UPDATE
    /**
     * Update an existing interview
     * @param interviewId the interview's ID
     * @param interview the updated interview data
     * @return the updated interview
     */
    Interview updateInterview(Long interviewId, Interview interview);
    
    // DELETE
    /**
     * Delete interview by ID
     * @param interviewId the interview's ID
     */
    void deleteInterview(Long interviewId);
    
    /**
     * Delete all interviews
     */
    void deleteAllInterviews();
    
    // UTILITY
    /**
     * Check if interview exists
     * @param interviewId the interview's ID
     * @return true if interview exists, false otherwise
     */
    boolean interviewExists(Long interviewId);
    
    /**
     * Get total number of interviews
     * @return count of all interviews
     */
    long getTotalInterviewCount();
    
    /**
     * Get total number of pending interviews
     * @return count of pending interviews
     */
    long getPendingInterviewCount();
}
