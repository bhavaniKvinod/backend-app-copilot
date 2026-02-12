package com.htc.backend.controller;

import com.htc.backend.model.Application;
import com.htc.backend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;
    
    // CREATE
    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        try {
            Application savedApplication = applicationService.saveApplication(application);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get all applications
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        try {
            List<Application> applications = applicationService.getAllApplications();
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by ID
    @GetMapping("/{appId}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long appId) {
        try {
            Optional<Application> application = applicationService.getApplicationById(appId);
            return application.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by seeker
    @GetMapping("/seeker/{seekerId}")
    public ResponseEntity<List<Application>> getApplicationsBySeeker(@PathVariable Long seekerId) {
        try {
            List<Application> applications = applicationService.getApplicationsBySeeker(seekerId);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by job
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsByJob(@PathVariable Long jobId) {
        try {
            List<Application> applications = applicationService.getApplicationsByJob(jobId);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Application>> getApplicationsByStatus(@PathVariable String status) {
        try {
            List<Application> applications = applicationService.getApplicationsByStatus(status);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by seeker and job
    @GetMapping("/seeker/{seekerId}/job/{jobId}")
    public ResponseEntity<Application> getApplicationBySeekerAndJob(
            @PathVariable Long seekerId,
            @PathVariable Long jobId) {
        try {
            Optional<Application> application = applicationService.getApplicationBySeekerAndJob(seekerId, jobId);
            return application.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get recent applications
    @GetMapping("/recent")
    public ResponseEntity<List<Application>> getRecentApplications(
            @RequestParam(defaultValue = "0") Integer daysAgo) {
        try {
            LocalDate appliedDate = LocalDate.now().minusDays(daysAgo);
            List<Application> applications = applicationService.getRecentApplications(appliedDate);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get pending applications
    @GetMapping("/pending")
    public ResponseEntity<List<Application>> getPendingApplications() {
        try {
            List<Application> applications = applicationService.getPendingApplications();
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by seeker and status
    @GetMapping("/seeker/{seekerId}/status/{status}")
    public ResponseEntity<List<Application>> getApplicationsBySeekerAndStatus(
            @PathVariable Long seekerId,
            @PathVariable String status) {
        try {
            List<Application> applications = applicationService.getApplicationsBySeekerAndStatus(seekerId, status);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE
    @PutMapping("/{appId}")
    public ResponseEntity<Application> updateApplication(
            @PathVariable Long appId,
            @RequestBody Application application) {
        try {
            Application updatedApplication = applicationService.updateApplication(appId, application);
            return ResponseEntity.ok(updatedApplication);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE
    @DeleteMapping("/{appId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long appId) {
        try {
            applicationService.deleteApplication(appId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - All applications
    @DeleteMapping
    public ResponseEntity<Void> deleteAllApplications() {
        try {
            applicationService.deleteAllApplications();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Check if application exists
    @GetMapping("/exists/{appId}")
    public ResponseEntity<Boolean> applicationExists(@PathVariable Long appId) {
        try {
            boolean exists = applicationService.applicationExists(appId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get total count
    @GetMapping("/count/total")
    public ResponseEntity<Long> getTotalApplicationCount() {
        try {
            long count = applicationService.getTotalApplicationCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get count by status
    @GetMapping("/count/status/{status}")
    public ResponseEntity<Long> getApplicationCountByStatus(@PathVariable String status) {
        try {
            long count = applicationService.getApplicationCountByStatus(status);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
