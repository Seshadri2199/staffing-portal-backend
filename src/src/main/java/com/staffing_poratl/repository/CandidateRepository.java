package com.staffing_poratl.repository;

import com.staffing_poratl.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CandidateRepository
    extends JpaRepository<Candidate, Long> {

    List<Candidate> findByCreatedAtBetween(
        LocalDateTime start, LocalDateTime end);

    List<Candidate> findByCandidateNameContainingIgnoreCase(
        String keyword);

    List<Candidate> findByFeedback(Candidate.Feedback feedback);
}