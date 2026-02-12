package com.htc.backend.repository;

import com.htc.backend.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    
    /**
     * Find employer by company name
     * @param companyName the company name
     * @return Optional containing the employer if found
     */
    Optional<Employer> findByCompanyName(String companyName);
    
    /**
     * Find all employers by industry
     * @param industry the industry sector
     * @return List of employers in the specified industry
     */
    List<Employer> findByIndustry(String industry);
    
    /**
     * Find all employers by location
     * @param location the company location
     * @return List of employers in the specified location
     */
    List<Employer> findByLocation(String location);
    
    /**
     * Find employer by email
     * @param email the employer's email
     * @return Optional containing the employer if found
     */
    Optional<Employer> findByEmail(String email);
    
    /**
     * Find employers by industry and location
     * @param industry the industry sector
     * @param location the company location
     * @return List of employers matching both criteria
     */
    List<Employer> findByIndustryAndLocation(String industry, String location);
}
