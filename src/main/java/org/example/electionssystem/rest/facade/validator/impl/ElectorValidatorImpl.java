package org.example.electionssystem.rest.facade.validator.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.ElectorValidator;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Component
@Slf4j
@AllArgsConstructor
public class ElectorValidatorImpl implements ElectorValidator {

    @Override
    public Optional<ErrorType> validateCreate(CreateElectorRequestDto requestDto) {
        log.debug("Executing validate create for request-{}", requestDto);

        if (requestDto.getFirstName() == null) {
            log.debug("Validation failed: Missing first name");
            return Optional.of(ErrorType.MISSING_FIRST_NAME);
        }

        if (requestDto.getLastName() == null) {
            log.debug("Validation failed: Missing last name");
            return Optional.of(ErrorType.MISSING_LAST_NAME);
        }

        if (requestDto.getDateOfBirth() == null) {
            log.debug("Validation failed: Missing date of birth");
            return Optional.of(ErrorType.MISSING_DATE_OF_BIRTH);
        }

        log.debug("Validation executed successfully");
        return Optional.empty();
    }
}
