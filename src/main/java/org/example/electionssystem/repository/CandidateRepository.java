package org.example.electionssystem.repository;

import org.example.electionssystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gurgen Bayburdyan
 */

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
