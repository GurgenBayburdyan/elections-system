package org.example.electionssystem.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.response.StatisticsDetailsDto;
import org.example.electionssystem.rest.facade.StatisticsFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsFacade facade;

    @GetMapping
    public ResponseEntity<StatisticsDetailsDto> findAll() {
        log.info("Executing get statistics rest API");

        ResponseEntity<StatisticsDetailsDto> responseEntity = ResponseEntity.ok(facade.getStatistics());

        log.info("Successfully executed get statistics, response entity-{}", responseEntity);
        return responseEntity;
    }
}
