package org.example.electionssystem.repository;

import org.example.electionssystem.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findAllByElectionLocation_Id(Long electionLocationId);

    Boolean existsByCandidate_Id(Long candidateId);
}
