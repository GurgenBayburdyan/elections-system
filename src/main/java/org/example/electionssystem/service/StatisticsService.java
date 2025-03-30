package org.example.electionssystem.service;

import java.util.Map;

/**
 * @author Gurgen Bayburdyan
 */


public interface StatisticsService {

    Integer electorCount();

    Integer voteCount();

    Integer candidateCount();

    Integer electionLocationCount();

    Map<Long, Map<Long, Float>> electedCandidatesInElectionLocations();

}
