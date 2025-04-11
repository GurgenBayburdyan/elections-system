package org.example.electionssystem.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ElectorDetailsDto;
import org.example.electionssystem.rest.facade.ElectorFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/electors")
public class ElectorController {

    private final ElectorFacade facade;

    @GetMapping
    public ResponseEntity<List<ElectorDetailsDto>> findAll() {
        log.info("Executing get all electors rest API");

        ResponseEntity<List<ElectorDetailsDto>> responseEntity = ResponseEntity.ok(facade.findAll());

        log.info("Successfully executed get all electors, response entity-{}", responseEntity);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<ElectorDetailsDto> create(@RequestBody CreateElectorRequestDto requestDto) {
        log.info("Executing create elector rest API, request-{}", requestDto);

        ResponseEntity<ElectorDetailsDto> responseEntity = ResponseEntity.ok(facade.create(requestDto));

        log.info("Successfully executed create elector, response entity-{}", responseEntity);
        return responseEntity;
    }

    @GetMapping("/{passportNumber}")
    public ResponseEntity<ElectorDetailsDto> findByPassportNumber(@PathVariable("passportNumber") String passportNumber) {
        log.info("Executing find elector by passport number rest API, passport number-{}", passportNumber);

        ResponseEntity<ElectorDetailsDto> responseEntity = ResponseEntity.ok(facade.findByPassportNumber(passportNumber));

        log.info("Successfully executed find elector by passport number, response entity-{}", responseEntity);
        return responseEntity;
    }
}
