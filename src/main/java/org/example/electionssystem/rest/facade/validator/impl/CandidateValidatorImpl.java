package org.example.electionssystem.rest.facade.validator.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateCandidateRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.CandidateValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Component
@Slf4j
@AllArgsConstructor
public class CandidateValidatorImpl implements CandidateValidator {
    @Override
    public Optional<ErrorType> validateCreate(CreateCandidateRequestDto requestDto) {
        log.debug("Executing validate create for request-{}", requestDto);

        if (requestDto.getFirstName() == null) {
            log.debug("Validation failed: Missing first name");
            return Optional.of(ErrorType.MISSING_FIRST_NAME);
        }

        if (requestDto.getLastName() == null) {
            log.debug("Validation failed: Missing last name");
            return Optional.of(ErrorType.MISSING_LAST_NAME);
        }

        if (requestDto.getNumber() == null) {
            log.debug("Validation failed: Missing number");
            return Optional.of(ErrorType.MISSING_NUMBER);
        }

        log.debug("Validation executed successfully");
        return Optional.empty();
    }

}
