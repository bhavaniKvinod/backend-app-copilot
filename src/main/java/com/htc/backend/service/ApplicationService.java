package com.htc.backend.service;

import com.htc.backend.model.Application;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface ApplicationService {
    
    // CREATE
    /**
     * Save a new application
     * @param application the application to save
     * @return the saved application
     */
    Application saveApplication(Application application);
    
    // READ
    /**
     * Get application by ID
     * @param appId the application's ID
     * @return Optional containing the application if found
     */
    Optional<Application> getApplicationById(Long appId);
    
    /**
     * Get all applications
     * @return List of all applications
     */
    List<Application> getAllApplications();
    
    /**
     * Get applications by job seeker
     * @param seekerId the job seeker's ID
     * @return List of applications submitted by the seeker
     */
    List<Application> getApplicationsBySeeker(Long seekerId);
    
    /**
     * Get applications for a specific job
     * @param jobId the job's ID
     * @return List of applications for the job
     */
    List<Application> getApplicationsByJob(Long jobId);
    
    /**
     * Get applications by status
     * @param status the application status
     * @return List of applications with the specified status
     */
    List<Application> getApplicationsByStatus(String status);
    
    /**
     * Get application by seeker and job
     * @param seekerId the job seeker's ID
     * @param jobId the job's ID
     * @return Optional containing the application if found
     */
    Optional<Application> getApplicationBySeekerAndJob(Long seekerId, Long jobId);
    
    /**
     * Get applications submitted after a specific date
     * @param appliedDate the date to search from
     * @return List of applications submitted after the specified date
     */
    List<Application> getRecentApplications(LocalDate appliedDate);
    
    /**
     * Get all pending applications
     * @return List of pending applications
     */
    List<Application> getPendingApplications();
    
    /**
     * Get applications by seeker and status
     * @param seekerId the job seeker's ID
     * @param status the application status
     * @return List of applications matching both criteria
     */
    List<Application> getApplicationsBySeekerAndStatus(Long seekerId, String status);
    
    // UPDATE
    /**
     * Update an existing application
     * @param appId the application's ID
     * @param application the updated application data
     * @return the updated application
     */
    Application updateApplication(Long appId, Application application);
    
    // DELETE
    /**
     * Delete application by ID
     * @param appId the application's ID
     */
    void deleteApplication(Long appId);
    
    /**
     * Delete all applications
     */
    void deleteAllApplications();
    
    // UTILITY
    /**
     * Check if application exists
     * @param appId the application's ID
     * @return true if application exists, false otherwise
     */
    boolean applicationExists(Long appId);
    
    /**
     * Get total number of applications
     * @return count of all applications
     */
    long getTotalApplicationCount();
    
    /**
     * Count applications by status
     * @param status the application status
     * @return count of applications with the specified status
     */
    long getApplicationCountByStatus(String status);
}
