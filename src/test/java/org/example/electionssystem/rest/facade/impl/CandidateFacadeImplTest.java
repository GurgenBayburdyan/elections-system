package org.example.electionssystem.rest.facade.impl;

import org.example.electionssystem.entity.Candidate;
import org.example.electionssystem.mapper.CandidateMapper;
import org.example.electionssystem.rest.dto.request.CreateCandidateRequestDto;
import org.example.electionssystem.rest.dto.response.CandidateDetailsDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.CandidateFacade;
import org.example.electionssystem.rest.facade.validator.CandidateValidator;
import org.example.electionssystem.service.CandidateService;
import org.example.electionssystem.service.params.CreateCandidateParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
class CandidateFacadeImplTest {

    @Mock
    private CandidateService candidateService;

    @Mock
    private CandidateMapper candidateMapper;

    @Mock
    private CandidateValidator candidateValidator;

    private CandidateFacade candidateFacade;

    @BeforeEach
    void setUp() {
        candidateFacade = new CandidateFacadeImpl(candidateService, candidateMapper, candidateValidator);
    }

    @Test
    void getAll() {
        List<Candidate> candidates = new ArrayList<>();
        List<CandidateDetailsDto> detailsDtos = new ArrayList<>();

        when(candidateService.getAll()).thenReturn(candidates);
        when(candidateMapper.toDetailsDtoList(candidates)).thenReturn(detailsDtos);

        List<CandidateDetailsDto> result = candidateFacade.findAll();

        assertEquals(detailsDtos, result);

        verify(candidateService).getAll();
        verify(candidateMapper).toDetailsDtoList(candidates);
    }

    @Test
    void create_success() {
        CreateCandidateRequestDto requestDto = new CreateCandidateRequestDto();
        Candidate candidate = new Candidate();
        CandidateDetailsDto detailsDto = new CandidateDetailsDto();

        CreateCandidateParams params = new CreateCandidateParams(
                "firstName",
                "lastName",
                1
        );

        when(candidateValidator.validateCreate(requestDto)).thenReturn(Optional.empty());
        when(candidateMapper.toCreateParams(requestDto)).thenReturn(params);
        when(candidateService.create(params)).thenReturn(candidate);
        when(candidateMapper.toDetailsDto(candidate)).thenReturn(detailsDto);

        CandidateDetailsDto result = candidateFacade.create(requestDto);

        assertEquals(detailsDto, result);

        verify(candidateValidator).validateCreate(requestDto);
        verify(candidateService).create(params);
        verify(candidateMapper).toDetailsDto(candidate);
    }

    @Test
    void create_MissingFirstName() {
        CreateCandidateRequestDto requestDto = new CreateCandidateRequestDto();
        when(candidateValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_FIRST_NAME));

        CandidateDetailsDto result = candidateFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_FIRST_NAME, result.getErrorType());

        verify(candidateValidator).validateCreate(requestDto);
    }

    @Test
    void create_MissingLastName() {
        CreateCandidateRequestDto requestDto = new CreateCandidateRequestDto();
        when(candidateValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_LAST_NAME));

        CandidateDetailsDto result = candidateFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_LAST_NAME, result.getErrorType());

        verify(candidateValidator).validateCreate(requestDto);
    }

    @Test
    void create_MissingNumber() {
        CreateCandidateRequestDto requestDto = new CreateCandidateRequestDto();
        when(candidateValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_NUMBER));

        CandidateDetailsDto result = candidateFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_NUMBER, result.getErrorType());

        verify(candidateValidator).validateCreate(requestDto);
    }

}