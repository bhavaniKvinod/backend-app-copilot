package com.htc.backend.service.impl;

import com.htc.backend.exception.ResourceNotFoundException;
import com.htc.backend.model.JobSeeker;
import com.htc.backend.repository.JobSeekerRepository;
import com.htc.backend.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
    
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    
    @Override
    public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }
    
    @Override
    public Optional<JobSeeker> getJobSeekerById(Long seekerId) {
        return jobSeekerRepository.findById(seekerId);
    }
    
    @Override
    public Optional<JobSeeker> getJobSeekerByEmail(String email) {
        return jobSeekerRepository.findByEmail(email);
    }
    
    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }
    
    @Override
    public List<JobSeeker> getJobSeekersByMinExperience(Integer minYears) {
        return jobSeekerRepository.findByExpYearsGreaterThanEqual(minYears);
    }
    
    @Override
    public List<JobSeeker> getJobSeekersBySkill(String skill) {
        return jobSeekerRepository.findBySkillsContaining(skill);
    }
    
    @Override
    public List<JobSeeker> getJobSeekersByExperienceRange(Integer minYears, Integer maxYears) {
        return jobSeekerRepository.findByExpYearsBetween(minYears, maxYears);
    }
    
    @Override
    public List<JobSeeker> getJobSeekersWithResume() {
        return jobSeekerRepository.findWithResume();
    }
    
    @Override
    public JobSeeker updateJobSeeker(Long seekerId, JobSeeker jobSeeker) {
        if (jobSeekerRepository.existsById(seekerId)) {
            jobSeeker.setUserId(seekerId);
            return jobSeekerRepository.save(jobSeeker);
        }
        throw new ResourceNotFoundException("Job Seeker", "seekerId", seekerId);
    }
    
    @Override
    public void deleteJobSeeker(Long seekerId) {
        if (jobSeekerRepository.existsById(seekerId)) {
            jobSeekerRepository.deleteById(seekerId);
        } else {
            throw new ResourceNotFoundException("Job Seeker", "seekerId", seekerId);
        }
    }
    
    @Override
    public void deleteAllJobSeekers() {
        jobSeekerRepository.deleteAll();
    }
    
    @Override
    public boolean jobSeekerExists(String email) {
        return jobSeekerRepository.findByEmail(email).isPresent();
    }
    
    @Override
    public long getTotalJobSeekerCount() {
        return jobSeekerRepository.count();
    }
}
