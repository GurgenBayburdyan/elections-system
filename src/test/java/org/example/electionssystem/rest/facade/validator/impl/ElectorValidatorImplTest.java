package org.example.electionssystem.rest.facade.validator.impl;

import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.ElectorValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Gurgen Bayburdyan
 */

@ExtendWith(MockitoExtension.class)
class ElectorValidatorImplTest {
    @Mock
    private ElectorValidator electorValidator;

    @BeforeEach
    void setUp() {
        electorValidator = new ElectorValidatorImpl();
    }

    @Test
    void validateCreate_MissingFirstName() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        requestDto.setFirstName(null);
        requestDto.setLastName("lastName");
        requestDto.setDateOfBirth(LocalDateTime.now());
        Optional<ErrorType> errorType = electorValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_FIRST_NAME);
    }

    @Test
    void validateCreate_MissingLastName() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        requestDto.setFirstName("firstName");
        requestDto.setLastName(null);
        requestDto.setDateOfBirth(LocalDateTime.now());
        Optional<ErrorType> errorType = electorValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_LAST_NAME);
    }

    @Test
    void validateCreate_MissingNumber() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        requestDto.setFirstName("firstName");
        requestDto.setLastName("lastName");
        requestDto.setDateOfBirth(null);
        Optional<ErrorType> errorType = electorValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_DATE_OF_BIRTH);
    }

}