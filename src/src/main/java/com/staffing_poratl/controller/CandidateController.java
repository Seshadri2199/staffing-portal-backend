package com.staffing_poratl.controller;

import com.staffing_poratl.model.Candidate;
import com.staffing_poratl.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<Candidate> getAll() {
        return candidateService.getAllCandidates();
    }

    @PostMapping
    public Candidate create(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }

    @PutMapping("/{id}")
    public Candidate update(@PathVariable Long id,
                            @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }

    @GetMapping("/search")
    public List<Candidate> search(@RequestParam String keyword) {
        return candidateService.searchCandidates(keyword);
    }
}