package com.htc.backend.repository;

import com.htc.backend.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    
    /**
     * Find interviews by application ID
     * @param appId the application ID
     * @return List of interviews for the application
     */
    List<Interview> findByAppId(Long appId);
    
    /**
     * Find interviews by interview mode
     * @param mode the interview mode (In-person, Video, Phone, etc.)
     * @return List of interviews with the specified mode
     */
    List<Interview> findByMode(String mode);
    
    /**
     * Find interviews by result
     * @param result the interview result (Pass, Fail, Pending, etc.)
     * @return List of interviews with the specified result
     */
    List<Interview> findByResult(String result);
    
    /**
     * Find interviews scheduled on a specific date
     * @param schedDate the scheduled date
     * @return List of interviews scheduled on the date
     */
    List<Interview> findBySchedDate(LocalDate schedDate);
    
    /**
     * Find interviews scheduled after a specific date
     * @param schedDate the date to search from
     * @return List of interviews scheduled after the specified date
     */
    List<Interview> findBySchedDateAfter(LocalDate schedDate);
    
    /**
     * Find interviews within a date range
     * @param startDate the start date
     * @param endDate the end date
     * @return List of interviews scheduled between the dates
     */
    List<Interview> findBySchedDateBetween(LocalDate startDate, LocalDate endDate);
    
    /**
     * Find pending interviews
     * @return List of interviews with null result (pending)
     */
    @Query("SELECT i FROM Interview i WHERE i.result IS NULL")
    List<Interview> findPendingInterviews();
    
    /**
     * Find interviews with feedback
     * @return List of interviews with feedback provided
     */
    @Query("SELECT i FROM Interview i WHERE i.feedback IS NOT NULL")
    List<Interview> findWithFeedback();
}
