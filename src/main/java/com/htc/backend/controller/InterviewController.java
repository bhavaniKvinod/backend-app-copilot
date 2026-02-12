package com.htc.backend.controller;

import com.htc.backend.model.Interview;
import com.htc.backend.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InterviewController {
    
    @Autowired
    private InterviewService interviewService;
    
    /**
     * Creates a new interview record.
     *
     * @param interview the interview object to be created containing interview details
     * @return ResponseEntity with HTTP 201 (CREATED) status and the saved interview object,
     *         or HTTP 500 (INTERNAL_SERVER_ERROR) if an exception occurs
     */
    // CREATE
    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        try {
            Interview savedInterview = interviewService.saveInterview(interview);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedInterview);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get all interviews
    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        try {
            List<Interview> interviews = interviewService.getAllInterviews();
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by ID
    @GetMapping("/{interviewId}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable Long interviewId) {
        try {
            Optional<Interview> interview = interviewService.getInterviewById(interviewId);
            return interview.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by application
    @GetMapping("/application/{appId}")
    public ResponseEntity<List<Interview>> getInterviewsByApplication(@PathVariable Long appId) {
        try {
            List<Interview> interviews = interviewService.getInterviewsByApplication(appId);
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by mode
    @GetMapping("/mode/{mode}")
    public ResponseEntity<List<Interview>> getInterviewsByMode(@PathVariable String mode) {
        try {
            List<Interview> interviews = interviewService.getInterviewsByMode(mode);
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by result
    @GetMapping("/result/{result}")
    public ResponseEntity<List<Interview>> getInterviewsByResult(@PathVariable String result) {
        try {
            List<Interview> interviews = interviewService.getInterviewsByResult(result);
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by scheduled date
    @GetMapping("/date/{schedDate}")
    public ResponseEntity<List<Interview>> getInterviewsBySchedDate(@PathVariable String schedDate) {
        try {
            LocalDate date = LocalDate.parse(schedDate);
            List<Interview> interviews = interviewService.getInterviewsBySchedDate(date);
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get upcoming interviews
    @GetMapping("/upcoming")
    public ResponseEntity<List<Interview>> getUpcomingInterviews(
            @RequestParam(defaultValue = "0") Integer daysFromNow) {
        try {
            LocalDate schedDate = LocalDate.now().plusDays(daysFromNow);
            List<Interview> interviews = interviewService.getUpcomingInterviews(schedDate);
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get by date range
    @GetMapping("/date-range")
    public ResponseEntity<List<Interview>> getInterviewsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            List<Interview> interviews = interviewService.getInterviewsByDateRange(start, end);
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get pending interviews
    @GetMapping("/pending")
    public ResponseEntity<List<Interview>> getPendingInterviews() {
        try {
            List<Interview> interviews = interviewService.getPendingInterviews();
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // READ - Get interviews with feedback
    @GetMapping("/with-feedback")
    public ResponseEntity<List<Interview>> getInterviewsWithFeedback() {
        try {
            List<Interview> interviews = interviewService.getInterviewsWithFeedback();
            return ResponseEntity.ok(interviews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE
    @PutMapping("/{interviewId}")
    public ResponseEntity<Interview> updateInterview(
            @PathVariable Long interviewId,
            @RequestBody Interview interview) {
        try {
            Interview updatedInterview = interviewService.updateInterview(interviewId, interview);
            return ResponseEntity.ok(updatedInterview);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE
    @DeleteMapping("/{interviewId}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long interviewId) {
        try {
            interviewService.deleteInterview(interviewId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // DELETE - All interviews
    @DeleteMapping
    public ResponseEntity<Void> deleteAllInterviews() {
        try {
            interviewService.deleteAllInterviews();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Check if interview exists
    @GetMapping("/exists/{interviewId}")
    public ResponseEntity<Boolean> interviewExists(@PathVariable Long interviewId) {
        try {
            boolean exists = interviewService.interviewExists(interviewId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get total count
    @GetMapping("/count/total")
    public ResponseEntity<Long> getTotalInterviewCount() {
        try {
            long count = interviewService.getTotalInterviewCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UTILITY - Get pending count
    @GetMapping("/count/pending")
    public ResponseEntity<Long> getPendingInterviewCount() {
        try {
            long count = interviewService.getPendingInterviewCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
