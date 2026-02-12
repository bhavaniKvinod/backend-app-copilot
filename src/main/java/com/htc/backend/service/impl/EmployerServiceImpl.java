package com.htc.backend.service.impl;

import com.htc.backend.model.Employer;
import com.htc.backend.repository.EmployerRepository;
import com.htc.backend.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    
    @Autowired
    private EmployerRepository employerRepository;
    
    @Override
    public Employer saveEmployer(Employer employer) {
        return employerRepository.save(employer);
    }
    
    @Override
    public Optional<Employer> getEmployerById(Long employerId) {
        return employerRepository.findById(employerId);
    }
    
    @Override
    public Optional<Employer> getEmployerByCompanyName(String companyName) {
        return employerRepository.findByCompanyName(companyName);
    }
    
    @Override
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }
    
    @Override
    public List<Employer> getEmployersByIndustry(String industry) {
        return employerRepository.findByIndustry(industry);
    }
    
    @Override
    public List<Employer> getEmployersByLocation(String location) {
        return employerRepository.findByLocation(location);
    }
    
    @Override
    public Optional<Employer> getEmployerByEmail(String email) {
        return employerRepository.findByEmail(email);
    }
    
    @Override
    public List<Employer> getEmployersByIndustryAndLocation(String industry, String location) {
        return employerRepository.findByIndustryAndLocation(industry, location);
    }
    
    @Override
    public Employer updateEmployer(Long employerId, Employer employer) {
        if (employerRepository.existsById(employerId)) {
            employer.setUserId(employerId);
            return employerRepository.save(employer);
        }
        throw new RuntimeException("Employer not found with ID: " + employerId);
    }
    
    @Override
    public void deleteEmployer(Long employerId) {
        if (employerRepository.existsById(employerId)) {
            employerRepository.deleteById(employerId);
        } else {
            throw new RuntimeException("Employer not found with ID: " + employerId);
        }
    }
    
    @Override
    public void deleteAllEmployers() {
        employerRepository.deleteAll();
    }
    
    @Override
    public boolean employerExists(String companyName) {
        return employerRepository.findByCompanyName(companyName).isPresent();
    }
    
    @Override
    public long getTotalEmployerCount() {
        return employerRepository.count();
    }
}
