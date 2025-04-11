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
import org.springframework.util.Assert;

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
    public List<Vote> getAll() {
        log.debug("Executing get all votes");

        List<Vote> votes = repository.findAll();

        log.debug("Successfully executed get all votes, {}", votes);
        return votes;
    }

    @Override
    @Transactional
    public Vote create(CreateVoteParams params) {
        Assert.notNull(params, "the params must not be null");
        log.debug("Executing create vote, params-{}", params);

        final Vote vote = new Vote();

        Candidate candidate = candidateService.getById(params.getCandidateId());
        Elector elector = electorService.getById(params.getElectorId());
        ElectionLocation electionLocation = electionLocationService.getById(params.getElectionLocationId());

        vote.setCandidate(candidate);
        vote.setElector(elector);
        vote.setElectionLocation(electionLocation);

        Vote saved = repository.save(vote);
        log.debug("Successfully executed create vote, {}", saved);
        return saved;
    }

    @Override
    public List<Vote> getByElectionLocationId(Long electionLocationId) {
        log.debug("Executing get all votes by election location id, id-{}", electionLocationId);

        List<Vote> votes = repository.findAllByElectionLocation_Id(electionLocationId);

        log.debug("Successfully executed get all votes by election location id, {}", votes);
        return votes;
    }

    @Override
    public Boolean existsByElectorId(Long electorId) {
        log.debug("Executing exists vote by elector id, id-{}", electorId);

        final Boolean response = repository.existsByElector_Id(electorId);

        log.debug("Successfully executed vote by elector id, {}", response);
        return response;
    }
}
