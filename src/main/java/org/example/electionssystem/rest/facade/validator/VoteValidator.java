package org.example.electionssystem.rest.facade.validator;

import org.example.electionssystem.rest.dto.request.CreateVoteRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */
public interface VoteValidator {

    Optional<ErrorType> validateCreate(CreateVoteRequestDto requestDto);

}
