package com.htc.backend.service.impl;

import com.htc.backend.exception.ResourceNotFoundException;
import com.htc.backend.model.Job;
import com.htc.backend.repository.JobRepository;
import com.htc.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    
    @Autowired
    private JobRepository jobRepository;
    
    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
    
    @Override
    public Optional<Job> getJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }
    
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
    @Override
    public List<Job> getJobsByEmployer(Long employerUserId) {
        return jobRepository.findByEmployerUserId(employerUserId);
    }
    
    @Override
    public List<Job> getJobsByStatus(String status) {
        return jobRepository.findByStatus(status);
    }
    
    @Override
    public List<Job> getJobsByJobType(String jobType) {
        return jobRepository.findByJobType(jobType);
    }
    
    @Override
    public List<Job> getJobsByTitle(String title) {
        return jobRepository.findByTitleContaining(title);
    }
    
    @Override
    public List<Job> getRecentJobs(LocalDate postedDate) {
        return jobRepository.findByPostedDateAfter(postedDate);
    }
    
    @Override
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByKeyword(keyword);
    }
    
    @Override
    public List<Job> getActiveJobsByEmployer(Long employerUserId) {
        return jobRepository.findByEmployerUserIdAndStatus(employerUserId, "ACTIVE");
    }
    
    @Override
    public Job updateJob(Long jobId, Job job) {
        if (jobRepository.existsById(jobId)) {
            job.setJobId(jobId);
            return jobRepository.save(job);
        }
        throw new ResourceNotFoundException("Job", "jobId", jobId);
    }
    
    @Override
    public void deleteJob(Long jobId) {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
        } else {
            throw new ResourceNotFoundException("Job", "jobId", jobId);
        }
    }
    
    @Override
    public void deleteAllJobs() {
        jobRepository.deleteAll();
    }
    
    @Override
    public boolean jobExists(Long jobId) {
        return jobRepository.existsById(jobId);
    }
    
    @Override
    public long getTotalJobCount() {
        return jobRepository.count();
    }
    
    @Override
    public long getActiveJobCount() {
        return jobRepository.findByStatus("ACTIVE").size();
    }
}
