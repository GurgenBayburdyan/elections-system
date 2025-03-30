package org.example.electionssystem.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.entity.Vote;
import org.example.electionssystem.service.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Service
@AllArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final VoteService voteService;
    private final ElectorService electorService;
    private final CandidateService candidateService;
    private final ElectionLocationService electionLocationService;

    @Override
    public Integer electorCount() {
        log.debug("Executing get electors count");

        final Integer count = electorService.findAll().size();

        log.debug("Successfully executed get electors count-{}", count);
        return count;
    }

    @Override
    public Integer voteCount() {
        log.debug("Executing get votes count");

        final Integer count = voteService.findAll().size();

        log.debug("Successfully executed get vote count-{}", count);
        return count;
    }

    @Override
    public Integer candidateCount() {
        log.debug("Executing get candidates count");

        final Integer count = candidateService.findAll().size();

        log.debug("Successfully executed get candidates count-{}", count);
        return count;
    }

    @Override
    public Integer electionLocationCount() {
        log.debug("Executing get election locations count");

        final Integer count = electionLocationService.findAll().size();

        log.debug("Successfully executed get election locations count-{}", count);
        return count;
    }

    @Override
    public Map<Long, Map<Long, Float>> electedCandidatesInElectionLocations() {
        Map<Long, Map<Long, Float>> electedCandidatesInElectionLocations = new HashMap<>();
        List<ElectionLocation> electionLocations = electionLocationService.findAll();

        for (ElectionLocation electionLocation : electionLocations) {
            Map<Long, Float> electedCandidatesInElectionLocation = new HashMap<>();
            List<Vote> votes = voteService.findByElectionLocationId(electionLocation.getId());

            Map<Long, Integer> candidateVoteCounts = new HashMap<>();

            for (Vote vote : votes) {
                Long candidateId = vote.getCandidate().getId();
                candidateVoteCounts.put(candidateId, candidateVoteCounts.getOrDefault(candidateId, 0) + 1);
            }

            int maxVotes = 0;

            for (Long candidateId : candidateVoteCounts.keySet()) {
                Integer voteCount = candidateVoteCounts.get(candidateId);
                if (voteCount > maxVotes) {
                    maxVotes = voteCount;
                }
            }


            for (Long candidateId : candidateVoteCounts.keySet()) {
                Integer voteCount = candidateVoteCounts.get(candidateId);
                float percentage = (float) voteCount / votes.size() * 100;
                electedCandidatesInElectionLocation.put(candidateId, percentage);
            }

            electedCandidatesInElectionLocations.put(electionLocation.getId(), electedCandidatesInElectionLocation);
        }

        return electedCandidatesInElectionLocations;
    }

}
