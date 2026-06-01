package com.staffing_poratl.controller;

import com.staffing_poratl.model.JobRequirement;
import com.staffing_poratl.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<JobRequirement> getAll() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public JobRequirement create(@RequestBody JobRequirement job) {
        return jobService.saveJob(job);
    }

    @PutMapping("/{jobCode}")
    public JobRequirement update(@PathVariable String jobCode,
                                 @RequestBody JobRequirement job) {
        return jobService.updateJob(jobCode, job);
    }

    @DeleteMapping("/{jobCode}")
    public void delete(@PathVariable String jobCode) {
        jobService.deleteJob(jobCode);
    }

    @GetMapping("/search")
    public List<JobRequirement> search(@RequestParam String keyword) {
        return jobService.searchJobs(keyword);
    }
}