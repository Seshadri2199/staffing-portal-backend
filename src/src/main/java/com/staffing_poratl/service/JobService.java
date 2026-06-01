package com.staffing_poratl.service;

import com.staffing_poratl.model.JobRequirement;
import com.staffing_poratl.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobRequirement> getAllJobs() {
        return jobRepository.findAll();
    }

    public JobRequirement saveJob(JobRequirement job) {
        job.setCreatedAt(LocalDateTime.now());
        job.setUpdatedAt(LocalDateTime.now());
        return jobRepository.save(job);
    }

    public JobRequirement updateJob(String jobCode, JobRequirement updated) {
        JobRequirement existing = jobRepository.findById(jobCode)
            .orElseThrow(() -> new RuntimeException("Job not found"));
        existing.setCompanyName(updated.getCompanyName());
        existing.setRoleName(updated.getRoleName());
        existing.setSkills(updated.getSkills());
        existing.setMandatorySkills(updated.getMandatorySkills());
        existing.setSalary(updated.getSalary());
        existing.setExperience(updated.getExperience());
        existing.setRelevantExperience(updated.getRelevantExperience());
        existing.setLocation(updated.getLocation());
        existing.setSpocName(updated.getSpocName());
        existing.setStatus(updated.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());
        return jobRepository.save(existing);
    }

    public void deleteJob(String jobCode) {
        jobRepository.deleteById(jobCode);
    }

    public List<JobRequirement> getByDateRange(
            LocalDateTime start, LocalDateTime end) {
        return jobRepository.findByCreatedAtBetween(start, end);
    }

    public List<JobRequirement> searchJobs(String keyword) {
        return jobRepository
            .findByCompanyNameContainingIgnoreCase(keyword);
    }
}