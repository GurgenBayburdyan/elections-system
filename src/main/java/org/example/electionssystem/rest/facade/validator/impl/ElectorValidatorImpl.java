package org.example.electionssystem.rest.facade.validator.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.ElectorValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Component
@Slf4j
@AllArgsConstructor
class ElectorValidatorImpl implements ElectorValidator {

    @Override
    public Optional<ErrorType> validateCreate(CreateElectorRequestDto requestDto) {
        log.debug("Executing validate create for request-{}", requestDto);

        if (ObjectUtils.isEmpty(requestDto.getFirstName())) {
            log.debug("Validation failed: Missing first name");
            return Optional.of(ErrorType.MISSING_FIRST_NAME);
        }

        if (ObjectUtils.isEmpty(requestDto.getLastName())) {
            log.debug("Validation failed: Missing last name");
            return Optional.of(ErrorType.MISSING_LAST_NAME);
        }

        if (ObjectUtils.isEmpty(requestDto.getDateOfBirth())) {
            log.debug("Validation failed: Missing date of birth");
            return Optional.of(ErrorType.MISSING_DATE_OF_BIRTH);
        }

        if (ObjectUtils.isEmpty(requestDto.getPassportNumber())) {
            log.debug("Validation failed: Missing passport number");
            return Optional.of(ErrorType.MISSING_PASSPORT_NUMBER);
        }

        log.debug("Validation executed successfully");
        return Optional.empty();
    }
}
