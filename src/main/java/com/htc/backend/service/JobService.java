package com.htc.backend.service;

import com.htc.backend.model.Job;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface JobService {
    
    // CREATE
    /**
     * Save a new job posting
     * @param job the job to save
     * @return the saved job
     */
    Job saveJob(Job job);
    
    // READ
    /**
     * Get job by ID
     * @param jobId the job's ID
     * @return Optional containing the job if found
     */
    Optional<Job> getJobById(Long jobId);
    
    /**
     * Get all jobs
     * @return List of all jobs
     */
    List<Job> getAllJobs();
    
    /**
     * Get jobs by employer
     * @param employerUserId the employer's user ID
     * @return List of jobs posted by the employer
     */
    List<Job> getJobsByEmployer(Long employerUserId);
    
    /**
     * Get jobs by status
     * @param status the job status
     * @return List of jobs with the specified status
     */
    List<Job> getJobsByStatus(String status);
    
    /**
     * Get jobs by job type
     * @param jobType the job type (Full-time, Part-time, etc.)
     * @return List of jobs with the specified type
     */
    List<Job> getJobsByJobType(String jobType);
    
    /**
     * Get jobs by title
     * @param title the job title
     * @return List of jobs matching the title
     */
    List<Job> getJobsByTitle(String title);
    
    /**
     * Get recent jobs posted after a specific date
     * @param postedDate the date to search from
     * @return List of jobs posted after the specified date
     */
    List<Job> getRecentJobs(LocalDate postedDate);
    
    /**
     * Search jobs by keyword
     * @param keyword keyword to search in job description/requirements
     * @return List of jobs matching the keyword
     */
    List<Job> searchJobs(String keyword);
    
    /**
     * Get active jobs by employer
     * @param employerUserId the employer's user ID
     * @return List of active jobs posted by the employer
     */
    List<Job> getActiveJobsByEmployer(Long employerUserId);
    
    // UPDATE
    /**
     * Update an existing job
     * @param jobId the job's ID
     * @param job the updated job data
     * @return the updated job
     */
    Job updateJob(Long jobId, Job job);
    
    // DELETE
    /**
     * Delete job by ID
     * @param jobId the job's ID
     */
    void deleteJob(Long jobId);
    
    /**
     * Delete all jobs
     */
    void deleteAllJobs();
    
    // UTILITY
    /**
     * Check if job exists by ID
     * @param jobId the job's ID
     * @return true if job exists, false otherwise
     */
    boolean jobExists(Long jobId);
    
    /**
     * Get total number of jobs
     * @return count of all jobs
     */
    long getTotalJobCount();
    
    /**
     * Get total number of active jobs
     * @return count of active jobs
     */
    long getActiveJobCount();
}
