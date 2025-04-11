package org.example.electionssystem.rest.facade.impl;

import org.example.electionssystem.entity.Elector;
import org.example.electionssystem.mapper.ElectorMapper;
import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ElectorDetailsDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.ElectorFacade;
import org.example.electionssystem.rest.facade.validator.ElectorValidator;
import org.example.electionssystem.service.ElectorService;
import org.example.electionssystem.service.params.CreateElectorParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Gurgen Bayburdyan
 */

@ExtendWith(MockitoExtension.class)
class ElectorFacadeImplTest {

    @Mock
    private ElectorService electorService;

    @Mock
    private ElectorMapper electorMapper;

    @Mock
    private ElectorValidator electorValidator;

    private ElectorFacade electorFacade;

    @BeforeEach
    void setUp() {
        electorFacade = new ElectorFacadeImpl(electorService, electorMapper, electorValidator);
    }

    @Test
    void getAll() {
        List< Elector> electors = new ArrayList<>();
        List< ElectorDetailsDto> detailsDtos = new ArrayList<>();

        when(electorService.getAll()).thenReturn(electors);
        when(electorMapper.toDetailsDtoList(electors)).thenReturn(detailsDtos);

        List<ElectorDetailsDto> result = electorFacade.findAll();

        assertEquals(detailsDtos, result);

        verify(electorService).getAll();
        verify(electorMapper).toDetailsDtoList(electors);
    }

    @Test
    void create_success() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        Elector elector = new Elector();
        ElectorDetailsDto detailsDto = new ElectorDetailsDto();

        CreateElectorParams params = new CreateElectorParams(
                "firstName",
                "lastName",
                LocalDateTime.now(),
                "132ABC"
        );

        when(electorValidator.validateCreate(requestDto)).thenReturn(Optional.empty());
        when(electorMapper.toCreateParams(requestDto)).thenReturn(params);
        when(electorService.create(params)).thenReturn(elector);
        when(electorMapper.toDetailsDto(elector)).thenReturn(detailsDto);

        ElectorDetailsDto result = electorFacade.create(requestDto);

        assertEquals(detailsDto, result);

        verify(electorValidator).validateCreate(requestDto);
        verify(electorService).create(params);
        verify(electorMapper).toCreateParams(requestDto);
    }

    @Test
    void create_MissingFirstName() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        when(electorValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_FIRST_NAME));

        ElectorDetailsDto result = electorFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_FIRST_NAME, result.getErrorType());

        verify(electorValidator).validateCreate(requestDto);
    }

    @Test
    void create_MissingLastName() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        when(electorValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_LAST_NAME));

        ElectorDetailsDto result = electorFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_LAST_NAME, result.getErrorType());

        verify(electorValidator).validateCreate(requestDto);
    }

    @Test
    void create_MissingDateOfBirth() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        when(electorValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_DATE_OF_BIRTH));

        ElectorDetailsDto result = electorFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_DATE_OF_BIRTH, result.getErrorType());

        verify(electorValidator).validateCreate(requestDto);
    }

    @Test
    void create_MissingPassportNumber() {
        CreateElectorRequestDto requestDto = new CreateElectorRequestDto();
        when(electorValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_PASSPORT_NUMBER));

        ElectorDetailsDto result = electorFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_PASSPORT_NUMBER, result.getErrorType());

        verify(electorValidator).validateCreate(requestDto);
    }


}