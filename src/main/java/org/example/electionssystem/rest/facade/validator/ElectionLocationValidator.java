package org.example.electionssystem.rest.facade.validator;

import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */
public interface ElectionLocationValidator {

    Optional<ErrorType> validateCreate(CreateElectionLocationRequestDto requestDto);

}
