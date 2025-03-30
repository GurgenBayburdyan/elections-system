package org.example.electionssystem.rest.facade.validator.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateVoteRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.VoteValidator;
import org.example.electionssystem.service.CandidateService;
import org.example.electionssystem.service.ElectionLocationService;
import org.example.electionssystem.service.ElectorService;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Component
@Slf4j
@AllArgsConstructor
public class VoteValidatorImpl implements VoteValidator {

    private final ElectorService electorService;
    private final ElectionLocationService electionLocationService;
    private final CandidateService candidateService;

    @Override
    public Optional<ErrorType> validateCreate(CreateVoteRequestDto requestDto) {
        log.debug("Executing validate create for request-{}", requestDto);

        if (requestDto.getCandidateId() == null) {
            log.debug("Validation failed: Missing candidate id");
            return Optional.of(ErrorType.MISSING_CANDIDATE_ID);
        }

        if (requestDto.getElectorId() == null) {
            log.debug("Validation failed: Missing elector id");
            return Optional.of(ErrorType.MISSING_ELECTOR_ID);
        }

        if (requestDto.getElectionLocationId() == null) {
            log.debug("Validation failed: Missing election location id");
            return Optional.of(ErrorType.MISSING_ELECTION_LOCATION_ID);
        }

        if (!candidateService.existsById(requestDto.getCandidateId())) {
            log.debug("Validation failed: Candidate not found");
            return Optional.of(ErrorType.CANDIDATE_NOT_FOUND);
        }

        if (!electorService.existsById(requestDto.getElectorId())) {
            log.debug("Validation failed: Elector not found");
            return Optional.of(ErrorType.ELECTOR_NOT_FOUND);
        }

        if (!electionLocationService.existsById(requestDto.getElectionLocationId())) {
            log.debug("Validation failed: Election location not found");
            return Optional.of(ErrorType.ELECTION_LOCATION_NOT_FOUND);
        }

        log.debug("Validation executed successfully");
        return Optional.empty();
    }
}
