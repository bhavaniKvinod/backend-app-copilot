package com.htc.backend.controller;

import com.htc.backend.model.JobSeeker;
import com.htc.backend.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-seekers")
@CrossOrigin(origins = "*", maxAge = 3600)
public class JobSeekerController {
    
    @Autowired
    private JobSeekerService jobSeekerService;
    
    // CREATE
    @PostMapping
    public ResponseEntity<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        try {
            JobSeeker savedJobSeeker = jobSeekerService.saveJobSeeker(jobSeeker);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedJobSeeker);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get all job seekers
    @GetMapping
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers() {
        try {
            List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers();
            return ResponseEntity.ok(jobSeekers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by ID
    @GetMapping("/{seekerId}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long seekerId) {
        try {
            Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(seekerId);
            return jobSeeker.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by email
    @GetMapping("/email/{email}")
    public ResponseEntity<JobSeeker> getJobSeekerByEmail(@PathVariable String email) {
        try {
            Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerByEmail(email);
            return jobSeeker.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by minimum experience
    @GetMapping("/experience/{minYears}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersByMinExperience(@PathVariable Integer minYears) {
        try {
            List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekersByMinExperience(minYears);
            return ResponseEntity.ok(jobSeekers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by skill
    @GetMapping("/skill/{skill}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersBySkill(@PathVariable String skill) {
        try {
            List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekersBySkill(skill);
            return ResponseEntity.ok(jobSeekers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by experience range
    @GetMapping("/experience-range")
    public ResponseEntity<List<JobSeeker>> getJobSeekersByExperienceRange(
            @RequestParam Integer minYears,
            @RequestParam Integer maxYears) {
        try {
            List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekersByExperienceRange(minYears, maxYears);
            return ResponseEntity.ok(jobSeekers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get job seekers with resume
    @GetMapping("/with-resume")
    public ResponseEntity<List<JobSeeker>> getJobSeekersWithResume() {
        try {
            List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekersWithResume();
            return ResponseEntity.ok(jobSeekers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE
    @PutMapping("/{seekerId}")
    public ResponseEntity<JobSeeker> updateJobSeeker(
            @PathVariable Long seekerId,
            @RequestBody JobSeeker jobSeeker) {
        try {
            JobSeeker updatedJobSeeker = jobSeekerService.updateJobSeeker(seekerId, jobSeeker);
            return ResponseEntity.ok(updatedJobSeeker);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE
    @DeleteMapping("/{seekerId}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long seekerId) {
        try {
            jobSeekerService.deleteJobSeeker(seekerId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - All job seekers
    @DeleteMapping
    public ResponseEntity<Void> deleteAllJobSeekers() {
        try {
            jobSeekerService.deleteAllJobSeekers();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Check if job seeker exists
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> jobSeekerExists(@PathVariable String email) {
        try {
            boolean exists = jobSeekerService.jobSeekerExists(email);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get total count
    @GetMapping("/count/total")
    public ResponseEntity<Long> getTotalJobSeekerCount() {
        try {
            long count = jobSeekerService.getTotalJobSeekerCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
