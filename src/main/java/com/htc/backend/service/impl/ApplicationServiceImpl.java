package com.htc.backend.service.impl;

import com.htc.backend.exception.ResourceNotFoundException;
import com.htc.backend.model.Application;
import com.htc.backend.repository.ApplicationRepository;
import com.htc.backend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Override
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }
    
    @Override
    public Optional<Application> getApplicationById(Long appId) {
        return applicationRepository.findById(appId);
    }
    
    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    
    @Override
    public List<Application> getApplicationsBySeeker(Long seekerId) {
        return applicationRepository.findBySeekerId(seekerId);
    }
    
    @Override
    public List<Application> getApplicationsByJob(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }
    
    @Override
    public List<Application> getApplicationsByStatus(String status) {
        return applicationRepository.findByStatus(status);
    }
    
    @Override
    public Optional<Application> getApplicationBySeekerAndJob(Long seekerId, Long jobId) {
        return applicationRepository.findBySeekersIdAndJobId(seekerId, jobId);
    }
    
    @Override
    public List<Application> getRecentApplications(LocalDate appliedDate) {
        return applicationRepository.findByAppliedDateAfter(appliedDate);
    }
    
    @Override
    public List<Application> getPendingApplications() {
        return applicationRepository.findPendingApplications();
    }
    
    @Override
    public List<Application> getApplicationsBySeekerAndStatus(Long seekerId, String status) {
        return applicationRepository.findBySeekerIdAndStatus(seekerId, status);
    }
    
    @Override
    public Application updateApplication(Long appId, Application application) {
        if (applicationRepository.existsById(appId)) {
            application.setAppId(appId);
            return applicationRepository.save(application);
        }
        throw new ResourceNotFoundException("Application", "appId", appId);
    }
    
    @Override
    public void deleteApplication(Long appId) {
        if (applicationRepository.existsById(appId)) {
            applicationRepository.deleteById(appId);
        } else {
            throw new ResourceNotFoundException("Application", "appId", appId);
        }
    }
    
    @Override
    public void deleteAllApplications() {
        applicationRepository.deleteAll();
    }
    
    @Override
    public boolean applicationExists(Long appId) {
        return applicationRepository.existsById(appId);
    }
    
    @Override
    public long getTotalApplicationCount() {
        return applicationRepository.count();
    }
    
    @Override
    public long getApplicationCountByStatus(String status) {
        return applicationRepository.countByStatus(status);
    }
}
