package com.htc.backend.repository;

import com.htc.backend.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    
    /**
     * Find job seeker by email
     * @param email the job seeker's email
     * @return Optional containing the job seeker if found
     */
    Optional<JobSeeker> findByEmail(String email);
    
    /**
     * Find all job seekers with minimum years of experience
     * @param minYears the minimum years of experience
     * @return List of job seekers with the specified minimum experience
     */
    List<JobSeeker> findByExpYearsGreaterThanEqual(Integer minYears);
    
    /**
     * Find job seekers by specific skill
     * @param skill the skill to search for
     * @return List of job seekers with the specified skill
     */
    @Query("SELECT js FROM JobSeeker js WHERE js.skills LIKE %:skill%")
    List<JobSeeker> findBySkillsContaining(@Param("skill") String skill);
    
    /**
     * Find job seekers by experience range
     * @param minYears the minimum years of experience
     * @param maxYears the maximum years of experience
     * @return List of job seekers within the experience range
     */
    List<JobSeeker> findByExpYearsBetween(Integer minYears, Integer maxYears);
    
    /**
     * Find job seekers with resume uploaded
     * @return List of job seekers who have uploaded a resume
     */
    @Query("SELECT js FROM JobSeeker js WHERE js.resumeUrl IS NOT NULL")
    List<JobSeeker> findWithResume();
}
