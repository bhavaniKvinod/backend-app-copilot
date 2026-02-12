package com.htc.backend.service;

import com.htc.backend.model.Employer;
import java.util.Optional;
import java.util.List;

public interface EmployerService {
    
    // CREATE
    /**
     * Save a new employer
     * @param employer the employer to save
     * @return the saved employer
     */
    Employer saveEmployer(Employer employer);
    
    // READ
    /**
     * Get employer by ID
     * @param employerId the employer's ID
     * @return Optional containing the employer if found
     */
    Optional<Employer> getEmployerById(Long employerId);
    
    /**
     * Get employer by company name
     * @param companyName the company name
     * @return Optional containing the employer if found
     */
    Optional<Employer> getEmployerByCompanyName(String companyName);
    
    /**
     * Get all employers
     * @return List of all employers
     */
    List<Employer> getAllEmployers();
    
    /**
     * Get employers by industry
     * @param industry the industry sector
     * @return List of employers in the specified industry
     */
    List<Employer> getEmployersByIndustry(String industry);
    
    /**
     * Get employers by location
     * @param location the company location
     * @return List of employers in the specified location
     */
    List<Employer> getEmployersByLocation(String location);
    
    /**
     * Get employer by email
     * @param email the employer's email
     * @return Optional containing the employer if found
     */
    Optional<Employer> getEmployerByEmail(String email);
    
    /**
     * Get employers by industry and location
     * @param industry the industry sector
     * @param location the company location
     * @return List of employers matching both criteria
     */
    List<Employer> getEmployersByIndustryAndLocation(String industry, String location);
    
    // UPDATE
    /**
     * Update an existing employer
     * @param employerId the employer's ID
     * @param employer the updated employer data
     * @return the updated employer
     */
    Employer updateEmployer(Long employerId, Employer employer);
    
    // DELETE
    /**
     * Delete employer by ID
     * @param employerId the employer's ID
     */
    void deleteEmployer(Long employerId);
    
    /**
     * Delete all employers
     */
    void deleteAllEmployers();
    
    // UTILITY
    /**
     * Check if employer exists by company name
     * @param companyName the company name
     * @return true if employer exists, false otherwise
     */
    boolean employerExists(String companyName);
    
    /**
     * Get total number of employers
     * @return count of all employers
     */
    long getTotalEmployerCount();
}
