package com.htc.backend.service.impl;

import com.htc.backend.exception.ResourceNotFoundException;
import com.htc.backend.model.Interview;
import com.htc.backend.repository.InterviewRepository;
import com.htc.backend.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    
    @Autowired
    private InterviewRepository interviewRepository;
    
    @Override
    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }
    
    @Override
    public Optional<Interview> getInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId);
    }
    
    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }
    
    @Override
    public List<Interview> getInterviewsByApplication(Long appId) {
        return interviewRepository.findByAppId(appId);
    }
    
    @Override
    public List<Interview> getInterviewsByMode(String mode) {
        return interviewRepository.findByMode(mode);
    }
    
    @Override
    public List<Interview> getInterviewsByResult(String result) {
        return interviewRepository.findByResult(result);
    }
    
    @Override
    public List<Interview> getInterviewsBySchedDate(LocalDate schedDate) {
        return interviewRepository.findBySchedDate(schedDate);
    }
    
    @Override
    public List<Interview> getUpcomingInterviews(LocalDate schedDate) {
        return interviewRepository.findBySchedDateAfter(schedDate);
    }
    
    @Override
    public List<Interview> getInterviewsByDateRange(LocalDate startDate, LocalDate endDate) {
        return interviewRepository.findBySchedDateBetween(startDate, endDate);
    }
    
    @Override
    public List<Interview> getPendingInterviews() {
        return interviewRepository.findPendingInterviews();
    }
    
    @Override
    public List<Interview> getInterviewsWithFeedback() {
        return interviewRepository.findWithFeedback();
    }
    
    @Override
    public Interview updateInterview(Long interviewId, Interview interview) {
        if (interviewRepository.existsById(interviewId)) {
            interview.setInterviewId(interviewId);
            return interviewRepository.save(interview);
        }
        throw new ResourceNotFoundException("Interview", "interviewId", interviewId);
    }
    
    @Override
    public void deleteInterview(Long interviewId) {
        if (interviewRepository.existsById(interviewId)) {
            interviewRepository.deleteById(interviewId);
        } else {
            throw new ResourceNotFoundException("Interview", "interviewId", interviewId);
        }
    }
    
    @Override
    public void deleteAllInterviews() {
        interviewRepository.deleteAll();
    }
    
    @Override
    public boolean interviewExists(Long interviewId) {
        return interviewRepository.existsById(interviewId);
    }
    
    @Override
    public long getTotalInterviewCount() {
        return interviewRepository.count();
    }
    
    @Override
    public long getPendingInterviewCount() {
        return interviewRepository.findPendingInterviews().size();
    }
}
