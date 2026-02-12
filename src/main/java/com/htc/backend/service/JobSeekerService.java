package com.htc.backend.service;

import com.htc.backend.model.JobSeeker;
import java.util.Optional;
import java.util.List;

public interface JobSeekerService {
    
    // CREATE
    /**
     * Save a new job seeker
     * @param jobSeeker the job seeker to save
     * @return the saved job seeker
     */
    JobSeeker saveJobSeeker(JobSeeker jobSeeker);
    
    // READ
    /**
     * Get job seeker by ID
     * @param seekerId the job seeker's ID
     * @return Optional containing the job seeker if found
     */
    Optional<JobSeeker> getJobSeekerById(Long seekerId);
    
    /**
     * Get job seeker by email
     * @param email the job seeker's email
     * @return Optional containing the job seeker if found
     */
    Optional<JobSeeker> getJobSeekerByEmail(String email);
    
    /**
     * Get all job seekers
     * @return List of all job seekers
     */
    List<JobSeeker> getAllJobSeekers();
    
    /**
     * Get job seekers with minimum years of experience
     * @param minYears the minimum years of experience
     * @return List of job seekers with the specified minimum experience
     */
    List<JobSeeker> getJobSeekersByMinExperience(Integer minYears);
    
    /**
     * Get job seekers by specific skill
     * @param skill the skill to search for
     * @return List of job seekers with the specified skill
     */
    List<JobSeeker> getJobSeekersBySkill(String skill);
    
    /**
     * Get job seekers by experience range
     * @param minYears the minimum years of experience
     * @param maxYears the maximum years of experience
     * @return List of job seekers within the experience range
     */
    List<JobSeeker> getJobSeekersByExperienceRange(Integer minYears, Integer maxYears);
    
    /**
     * Get job seekers with resume uploaded
     * @return List of job seekers who have uploaded a resume
     */
    List<JobSeeker> getJobSeekersWithResume();
    
    // UPDATE
    /**
     * Update an existing job seeker
     * @param seekerId the job seeker's ID
     * @param jobSeeker the updated job seeker data
     * @return the updated job seeker
     */
    JobSeeker updateJobSeeker(Long seekerId, JobSeeker jobSeeker);
    
    // DELETE
    /**
     * Delete job seeker by ID
     * @param seekerId the job seeker's ID
     */
    void deleteJobSeeker(Long seekerId);
    
    /**
     * Delete all job seekers
     */
    void deleteAllJobSeekers();
    
    // UTILITY
    /**
     * Check if job seeker exists by email
     * @param email the job seeker's email
     * @return true if job seeker exists, false otherwise
     */
    boolean jobSeekerExists(String email);
    
    /**
     * Get total number of job seekers
     * @return count of all job seekers
     */
    long getTotalJobSeekerCount();
}
