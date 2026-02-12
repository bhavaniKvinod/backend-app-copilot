package com.htc.backend.controller;

import com.htc.backend.model.Job;
import com.htc.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class JobController {
    
    @Autowired
    private JobService jobService;
    
    // CREATE
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        try {
            Job savedJob = jobService.saveJob(job);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedJob);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get all jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        try {
            List<Job> jobs = jobService.getAllJobs();
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by ID
    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        try {
            Optional<Job> job = jobService.getJobById(jobId);
            return job.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by employer
    @GetMapping("/employer/{employerUserId}")
    public ResponseEntity<List<Job>> getJobsByEmployer(@PathVariable Long employerUserId) {
        try {
            List<Job> jobs = jobService.getJobsByEmployer(employerUserId);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Job>> getJobsByStatus(@PathVariable String status) {
        try {
            List<Job> jobs = jobService.getJobsByStatus(status);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by job type
    @GetMapping("/type/{jobType}")
    public ResponseEntity<List<Job>> getJobsByJobType(@PathVariable String jobType) {
        try {
            List<Job> jobs = jobService.getJobsByJobType(jobType);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by title
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Job>> getJobsByTitle(@PathVariable String title) {
        try {
            List<Job> jobs = jobService.getJobsByTitle(title);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get recent jobs
    @GetMapping("/recent")
    public ResponseEntity<List<Job>> getRecentJobs(
            @RequestParam(defaultValue = "0") Integer daysAgo) {
        try {
            LocalDate postedDate = LocalDate.now().minusDays(daysAgo);
            List<Job> jobs = jobService.getRecentJobs(postedDate);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Search jobs
    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam String keyword) {
        try {
            List<Job> jobs = jobService.searchJobs(keyword);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get active jobs by employer
    @GetMapping("/employer/{employerUserId}/active")
    public ResponseEntity<List<Job>> getActiveJobsByEmployer(@PathVariable Long employerUserId) {
        try {
            List<Job> jobs = jobService.getActiveJobsByEmployer(employerUserId);
            return ResponseEntity.ok(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE
    @PutMapping("/{jobId}")
    public ResponseEntity<Job> updateJob(
            @PathVariable Long jobId,
            @RequestBody Job job) {
        try {
            Job updatedJob = jobService.updateJob(jobId, job);
            return ResponseEntity.ok(updatedJob);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE
    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId) {
        try {
            jobService.deleteJob(jobId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - All jobs
    @DeleteMapping
    public ResponseEntity<Void> deleteAllJobs() {
        try {
            jobService.deleteAllJobs();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Check if job exists
    @GetMapping("/exists/{jobId}")
    public ResponseEntity<Boolean> jobExists(@PathVariable Long jobId) {
        try {
            boolean exists = jobService.jobExists(jobId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get total count
    @GetMapping("/count/total")
    public ResponseEntity<Long> getTotalJobCount() {
        try {
            long count = jobService.getTotalJobCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get active jobs count
    @GetMapping("/count/active")
    public ResponseEntity<Long> getActiveJobCount() {
        try {
            long count = jobService.getActiveJobCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
