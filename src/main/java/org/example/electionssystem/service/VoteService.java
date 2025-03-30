package org.example.electionssystem.service;

import org.example.electionssystem.entity.Vote;
import org.example.electionssystem.service.params.CreateVoteParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface VoteService {

    List<Vote> findAll();

    Vote create(CreateVoteParams params);

    List<Vote> findByElectionLocationId(Long electionLocationId);

}
