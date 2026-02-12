package com.htc.backend.controller;

import com.htc.backend.model.Employer;
import com.htc.backend.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployerController {
    
    @Autowired
    private EmployerService employerService;
    
    // CREATE
    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        try {
            Employer savedEmployer = employerService.saveEmployer(employer);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get all employers
    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers() {
        try {
            List<Employer> employers = employerService.getAllEmployers();
            return ResponseEntity.ok(employers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by ID
    @GetMapping("/{employerId}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long employerId) {
        try {
            Optional<Employer> employer = employerService.getEmployerById(employerId);
            return employer.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by company name
    @GetMapping("/company/{companyName}")
    public ResponseEntity<Employer> getEmployerByCompanyName(@PathVariable String companyName) {
        try {
            Optional<Employer> employer = employerService.getEmployerByCompanyName(companyName);
            return employer.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Employer> getEmployerByEmail(@PathVariable String email) {
        try {
            Optional<Employer> employer = employerService.getEmployerByEmail(email);
            return employer.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by industry
    @GetMapping("/industry/{industry}")
    public ResponseEntity<List<Employer>> getEmployersByIndustry(@PathVariable String industry) {
        try {
            List<Employer> employers = employerService.getEmployersByIndustry(industry);
            return ResponseEntity.ok(employers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Employer>> getEmployersByLocation(@PathVariable String location) {
        try {
            List<Employer> employers = employerService.getEmployersByLocation(location);
            return ResponseEntity.ok(employers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by industry and location
    @GetMapping("/search")
    public ResponseEntity<List<Employer>> getEmployersByIndustryAndLocation(
            @RequestParam String industry,
            @RequestParam String location) {
        try {
            List<Employer> employers = employerService.getEmployersByIndustryAndLocation(industry, location);
            return ResponseEntity.ok(employers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE
    @PutMapping("/{employerId}")
    public ResponseEntity<Employer> updateEmployer(
            @PathVariable Long employerId,
            @RequestBody Employer employer) {
        try {
            Employer updatedEmployer = employerService.updateEmployer(employerId, employer);
            return ResponseEntity.ok(updatedEmployer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE
    @DeleteMapping("/{employerId}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long employerId) {
        try {
            employerService.deleteEmployer(employerId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - All employers
    @DeleteMapping
    public ResponseEntity<Void> deleteAllEmployers() {
        try {
            employerService.deleteAllEmployers();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Check if employer exists
    @GetMapping("/exists/{companyName}")
    public ResponseEntity<Boolean> employerExists(@PathVariable String companyName) {
        try {
            boolean exists = employerService.employerExists(companyName);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get total count
    @GetMapping("/count/total")
    public ResponseEntity<Long> getTotalEmployerCount() {
        try {
            long count = employerService.getTotalEmployerCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
