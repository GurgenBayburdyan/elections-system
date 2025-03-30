package org.example.electionssystem.rest.facade.validator;

import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

public interface ElectorValidator {

    Optional<ErrorType> validateCreate(CreateElectorRequestDto requestDto);

}
