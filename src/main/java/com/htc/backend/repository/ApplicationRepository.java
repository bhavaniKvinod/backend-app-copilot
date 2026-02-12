package com.htc.backend.repository;

import com.htc.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
    /**
     * Find all applications by a specific job seeker
     * @param seekerId the job seeker's ID
     * @return List of applications submitted by the seeker
     */
    List<Application> findBySeekerId(Long seekerId);
    
    /**
     * Find all applications for a specific job
     * @param jobId the job's ID
     * @return List of applications for the job
     */
    List<Application> findByJobId(Long jobId);
    
    /**
     * Find applications by status
     * @param status the application status
     * @return List of applications with the specified status
     */
    List<Application> findByStatus(String status);
    
    /**
     * Find application by seeker and job
     * @param seekerId the job seeker's ID
     * @param jobId the job's ID
     * @return Optional containing the application if found
     */
    Optional<Application> findBySeekersIdAndJobId(Long seekerId, Long jobId);
    
    /**
     * Find applications submitted after a specific date
     * @param appliedDate the date to search from
     * @return List of applications submitted after the specified date
     */
    List<Application> findByAppliedDateAfter(LocalDate appliedDate);
    
    /**
     * Find all pending applications
     * @return List of pending applications
     */
    @Query("SELECT a FROM Application a WHERE a.status = 'PENDING'")
    List<Application> findPendingApplications();
    
    /**
     * Count applications by status
     * @param status the application status
     * @return Count of applications with the specified status
     */
    long countByStatus(String status);
    
    /**
     * Find applications by seeker and status
     * @param seekerId the job seeker's ID
     * @param status the application status
     * @return List of applications matching both criteria
     */
    List<Application> findBySeekerIdAndStatus(Long seekerId, String status);
}
