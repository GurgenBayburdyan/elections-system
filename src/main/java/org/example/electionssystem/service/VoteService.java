package org.example.electionssystem.service;

import org.example.electionssystem.entity.Vote;
import org.example.electionssystem.service.params.CreateVoteParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface VoteService {

    List<Vote> getAll();

    Vote create(CreateVoteParams params);

    List<Vote> getByElectionLocationId(Long electionLocationId);

    Boolean existsByCandidateId(Long candidateId);

}
