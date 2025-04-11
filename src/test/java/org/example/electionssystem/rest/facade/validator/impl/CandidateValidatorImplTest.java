package org.example.electionssystem.rest.facade.validator.impl;

import org.example.electionssystem.rest.dto.request.CreateCandidateRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.CandidateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Gurgen Bayburdyan
 */

@ExtendWith(MockitoExtension.class)
class CandidateValidatorImplTest {
    @Mock
    private CandidateValidator candidateValidator;

    @BeforeEach
    void setUp() {
        candidateValidator = new CandidateValidatorImpl();
    }

    @Test
    void validateCreate_MissingFirstName() {
        CreateCandidateRequestDto requestDto = new CreateCandidateRequestDto();
        requestDto.setFirstName(null);
        requestDto.setLastName("lastName");
        requestDto.setNumber(1);
        Optional<ErrorType> errorType = candidateValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_FIRST_NAME);
    }

    @Test
    void validateCreate_MissingLastName() {
        CreateCandidateRequestDto requestDto = new CreateCandidateRequestDto();
        requestDto.setFirstName("firstName");
        requestDto.setLastName(null);
        requestDto.setNumber(1);
        Optional<ErrorType> errorType = candidateValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_LAST_NAME);
    }

    @Test
    void validateCreate_MissingNumber() {
        CreateCandidateRequestDto requestDto = new CreateCandidateRequestDto();
        requestDto.setFirstName("firstName");
        requestDto.setLastName("lastName");
        requestDto.setNumber(null);
        Optional<ErrorType> errorType = candidateValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_NUMBER);
    }

}