package org.example.electionssystem.rest.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.response.StatisticsDetailsDto;
import org.example.electionssystem.rest.facade.StatisticsFacade;
import org.example.electionssystem.service.StatisticsService;
import org.springframework.stereotype.Service;


/**
 * @author Gurgen Bayburdyan
 */

@Service
@Slf4j
@AllArgsConstructor
public class StatisticsFacadeImpl implements StatisticsFacade {

    private final StatisticsService statisticsService;

    @Override
    public StatisticsDetailsDto getStatistics() {
        log.info("Executing get statistics rest API");

        StatisticsDetailsDto statisticsDetailsDto = new StatisticsDetailsDto();
        statisticsDetailsDto.setCandidateCount(statisticsService.candidateCount());
        statisticsDetailsDto.setElectionLocationCount(statisticsService.electionLocationCount());
        statisticsDetailsDto.setVoteCount(statisticsService.voteCount());
        statisticsDetailsDto.setElectorCount(statisticsService.electorCount());
        statisticsDetailsDto.setStatistics(statisticsService.electedCandidatesInElectionLocations());

        log.info("Successfully executed get statistics rest API, response - {}", statisticsDetailsDto);
        return statisticsDetailsDto;
    }
}
