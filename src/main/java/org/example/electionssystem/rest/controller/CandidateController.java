package org.example.electionssystem.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateCandidateRequestDto;
import org.example.electionssystem.rest.dto.response.CandidateDetailsDto;
import org.example.electionssystem.rest.facade.CandidateFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateFacade facade;

    @GetMapping
    public ResponseEntity<List<CandidateDetailsDto>> findAll() {
        log.info("Executing get all candidates rest API");

        ResponseEntity<List<CandidateDetailsDto>> responseEntity = ResponseEntity.ok(facade.findAll());

        log.info("Successfully executed get all candidates, response entity-{}", responseEntity);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<CandidateDetailsDto> create(@RequestBody CreateCandidateRequestDto requestDto) {
        log.info("Executing create candidate rest API, request-{}", requestDto);

        ResponseEntity<CandidateDetailsDto> responseEntity = ResponseEntity.ok(facade.create(requestDto));

        log.info("Successfully executed create candidate, response entity-{}", responseEntity);
        return responseEntity;
    }
}
