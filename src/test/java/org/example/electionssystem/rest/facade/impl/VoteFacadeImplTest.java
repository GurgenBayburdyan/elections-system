package org.example.electionssystem.rest.facade.impl;

import org.example.electionssystem.entity.Vote;
import org.example.electionssystem.mapper.VoteMapper;
import org.example.electionssystem.rest.dto.request.CreateVoteRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.dto.response.VoteDetailsDto;
import org.example.electionssystem.rest.facade.VoteFacade;
import org.example.electionssystem.rest.facade.validator.VoteValidator;
import org.example.electionssystem.service.VoteService;
import org.example.electionssystem.service.params.CreateVoteParams;
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
class VoteFacadeImplTest {

    @Mock
    private VoteService voteService;

    @Mock
    private VoteMapper voteMapper;

    @Mock
    private VoteValidator voteValidator;

    private VoteFacade voteFacade;

    @BeforeEach
    void setUp() {
        voteFacade = new VoteFacadeImpl(voteService, voteMapper, voteValidator);
    }

    @Test
    void getAll() {
        List<Vote> votes = new ArrayList<>();
        List<VoteDetailsDto> detailsDtos = new ArrayList<>();

        when(voteService.getAll()).thenReturn(votes);
        when(voteMapper.toDetailsDtoList(votes)).thenReturn(detailsDtos);

        List<VoteDetailsDto> result = voteFacade.findAll();

        assertEquals(detailsDtos, result);

        verify(voteService).getAll();
        verify(voteMapper).toDetailsDtoList(votes);
    }

    @Test
    void create_success() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        Vote vote = new Vote();
        VoteDetailsDto detailsDto = new VoteDetailsDto();

        CreateVoteParams params = new CreateVoteParams(
                1L,
                1L,
                1L
        );

        when(voteValidator.validateCreate(requestDto)).thenReturn(Optional.empty());
        when(voteMapper.toCreateParams(requestDto)).thenReturn(params);
        when(voteService.create(params)).thenReturn(vote);
        when(voteMapper.toDetailsDto(vote)).thenReturn(detailsDto);

        VoteDetailsDto result = voteFacade.create(requestDto);

        assertEquals(detailsDto, result);

        verify(voteValidator).validateCreate(requestDto);
        verify(voteService).create(params);
        verify(voteMapper).toCreateParams(requestDto);
    }

    @Test
    void create_MissingElectorId() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        when(voteValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_ELECTOR_ID));

        VoteDetailsDto result = voteFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_ELECTOR_ID, result.getErrorType());

        verify(voteValidator).validateCreate(requestDto);
    }

    @Test
    void create_MissingElectionLocationId() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        when(voteValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_ELECTION_LOCATION_ID));

        VoteDetailsDto result = voteFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_ELECTION_LOCATION_ID, result.getErrorType());

        verify(voteValidator).validateCreate(requestDto);
    }

    @Test
    void create_MissingCandidateId() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        when(voteValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_CANDIDATE_ID));

        VoteDetailsDto result = voteFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_CANDIDATE_ID, result.getErrorType());

        verify(voteValidator).validateCreate(requestDto);
    }

    @Test
    void create_ElectorNotFound() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        when(voteValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.ELECTOR_NOT_FOUND));

        VoteDetailsDto result = voteFacade.create(requestDto);

        assertEquals(ErrorType.ELECTOR_NOT_FOUND, result.getErrorType());

        verify(voteValidator).validateCreate(requestDto);
    }

    @Test
    void create_ElectionLocationNotFound() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        when(voteValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.ELECTION_LOCATION_NOT_FOUND));

        VoteDetailsDto result = voteFacade.create(requestDto);

        assertEquals(ErrorType.ELECTION_LOCATION_NOT_FOUND, result.getErrorType());

        verify(voteValidator).validateCreate(requestDto);
    }

    @Test
    void create_CandidateNotFound() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        when(voteValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.CANDIDATE_NOT_FOUND));

        VoteDetailsDto result = voteFacade.create(requestDto);

        assertEquals(ErrorType.CANDIDATE_NOT_FOUND, result.getErrorType());

        verify(voteValidator).validateCreate(requestDto);
    }

}