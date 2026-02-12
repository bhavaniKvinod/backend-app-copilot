package com.htc.backend.repository;

import com.htc.backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
    /**
     * Find all jobs posted by a specific employer
     * @param employerUserId the employer's user ID
     * @return List of jobs posted by the employer
     */
    List<Job> findByEmployerUserId(Long employerUserId);
    
    /**
     * Find all active jobs
     * @return List of active jobs
     */
    List<Job> findByStatus(String status);
    
    /**
     * Find jobs by title
     * @param title the job title
     * @return List of jobs matching the title
     */
    @Query("SELECT j FROM Job j WHERE j.title LIKE %:title%")
    List<Job> findByTitleContaining(@Param("title") String title);
    
    /**
     * Find jobs by job type
     * @param jobType the job type (Full-time, Part-time, etc.)
     * @return List of jobs with the specified type
     */
    List<Job> findByJobType(String jobType);
    
    /**
     * Find jobs posted after a specific date
     * @param postedDate the date to search from
     * @return List of jobs posted after the specified date
     */
    List<Job> findByPostedDateAfter(LocalDate postedDate);
    
    /**
     * Find jobs by description keywords
     * @param description keyword to search in job description
     * @return List of jobs matching the description
     */
    @Query("SELECT j FROM Job j WHERE j.description LIKE %:keyword% OR j.requirements LIKE %:keyword%")
    List<Job> findByKeyword(@Param("keyword") String keyword);
    
    /**
     * Find active jobs by employer
     * @param employerUserId the employer's user ID
     * @param status the job status
     * @return List of active jobs posted by the employer
     */
    List<Job> findByEmployerUserIdAndStatus(Long employerUserId, String status);
}
