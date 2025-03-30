package org.example.electionssystem.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ElectionLocationDetailsDto;
import org.example.electionssystem.rest.facade.ElectionLocationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/electionLocation")
public class ElectionLocationController {

    private final ElectionLocationFacade facade;

    @GetMapping
    public ResponseEntity<List<ElectionLocationDetailsDto>> findAll() {
        log.info("Executing get all electors rest API");

        final ResponseEntity<List<ElectionLocationDetailsDto>> responseEntity = ResponseEntity.ok(facade.findAll());

        log.info("Successfully executed get all election locations, response entity-{}", responseEntity);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<ElectionLocationDetailsDto> create(@RequestBody CreateElectionLocationRequestDto requestDto) {
        log.info("Executing create election location rest API, request-{}", requestDto);

        ResponseEntity<ElectionLocationDetailsDto> responseEntity = ResponseEntity.ok(facade.create(requestDto));

        log.info("Successfully executed create election location, response entity-{}", responseEntity);
        return responseEntity;
    }

}
