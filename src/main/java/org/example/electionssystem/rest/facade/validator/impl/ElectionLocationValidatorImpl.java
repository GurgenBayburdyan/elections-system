package org.example.electionssystem.rest.facade.validator.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.ElectionLocationValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Component
@Slf4j
@AllArgsConstructor
class ElectionLocationValidatorImpl implements ElectionLocationValidator {

    @Override
    public Optional<ErrorType> validateCreate(CreateElectionLocationRequestDto requestDto) {
        log.debug("Executing validate create for request-{}", requestDto);

        if (ObjectUtils.isEmpty(requestDto.getAddress())) {
            log.debug("Validation failed: Missing address");
            return Optional.of(ErrorType.MISSING_ADDRESS);
        }

        log.debug("Validation executed successfully");
        return Optional.empty();
    }

}
