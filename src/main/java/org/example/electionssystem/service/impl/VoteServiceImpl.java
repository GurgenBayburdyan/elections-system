package org.example.electionssystem.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Candidate;
import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.entity.Elector;
import org.example.electionssystem.entity.Vote;
import org.example.electionssystem.repository.VoteRepository;
import org.example.electionssystem.service.CandidateService;
import org.example.electionssystem.service.ElectionLocationService;
import org.example.electionssystem.service.ElectorService;
import org.example.electionssystem.service.VoteService;
import org.example.electionssystem.service.params.CreateVoteParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Service
@AllArgsConstructor
class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    private final ElectorService electorService;
    private final CandidateService candidateService;
    private final ElectionLocationService electionLocationService;

    @Override
    @Transactional(readOnly = true)
    public List<Vote> findAll() {
        log.debug("Executing get all votes");

        List<Vote> votes = repository.findAll();

        log.debug("Successfully executed get all votes, {}", votes);
        return votes;
    }

    @Override
    @Transactional
    public Vote create(CreateVoteParams params) {
        log.debug("Executing create vote, params-{}", params);

        final Vote vote = new Vote();

        //todo lets keep the convention that if method starts with findBy, then it must return an Optional, if starts with getBy, then it returns an non-nullable entity.
        Candidate candidate = candidateService.findById(params.getCandidateId());
        Elector elector = electorService.findById(params.getElectorId());
        ElectionLocation electionLocation = electionLocationService.findById(params.getElectionLocationId());

        vote.setCandidate(candidate);
        vote.setElector(elector);
        vote.setElectionLocation(electionLocation);

        log.debug("Successfully executed create vote, {}", vote);
        return repository.save(vote);
    }

    @Override
    public List<Vote> findByElectionLocationId(Long electionLocationId) {
        log.debug("Executing get all votes by election location id, id-{}", electionLocationId);

        List<Vote> votes = repository.findAllByElectionLocation_Id(electionLocationId);

        log.debug("Successfully executed get all votes by election location id, {}", votes);
        return votes;
    }
}
