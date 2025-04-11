package org.example.electionssystem.rest.facade.validator.impl;

import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.ElectionLocationValidator;
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
class ElectionLocationValidatorImplTest {
    @Mock
    private ElectionLocationValidator electionLocationValidator;

    @BeforeEach
    void setUp() {
        electionLocationValidator = new ElectionLocationValidatorImpl();
    }

    @Test
    void validateCreate_MissingAddress() {
        CreateElectionLocationRequestDto requestDto = new CreateElectionLocationRequestDto();
        requestDto.setAddress(null);
        Optional<ErrorType> errorType = electionLocationValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_ADDRESS);
    }

}