package org.example.electionssystem.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateVoteRequestDto;
import org.example.electionssystem.rest.dto.response.VoteDetailsDto;
import org.example.electionssystem.rest.facade.VoteFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/votes")
public class VoteController {

    private final VoteFacade facade;

    @GetMapping
    public ResponseEntity<List<VoteDetailsDto>> findAll() {
        log.info("Executing find all votes rest API");

        ResponseEntity<List<VoteDetailsDto>> responseEntity = ResponseEntity.ok(facade.findAll());

        log.info("Successfully executed get all votes, response entity-{}", responseEntity);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<VoteDetailsDto> create(@RequestBody CreateVoteRequestDto requestDto) {
        log.info("Executing create votes rest API, request-{}", requestDto);

        ResponseEntity<VoteDetailsDto> responseEntity = ResponseEntity.ok(facade.create(requestDto));

        log.info("Successfully executed create vote, response entity-{}", responseEntity);
        return responseEntity;
    }
}
