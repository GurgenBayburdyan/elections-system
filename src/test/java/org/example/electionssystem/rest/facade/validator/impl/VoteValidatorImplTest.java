package org.example.electionssystem.rest.facade.validator.impl;

import org.example.electionssystem.rest.dto.request.CreateVoteRequestDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.validator.VoteValidator;
import org.example.electionssystem.service.CandidateService;
import org.example.electionssystem.service.ElectionLocationService;
import org.example.electionssystem.service.ElectorService;
import org.example.electionssystem.service.VoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


/**
 * @author Gurgen Bayburdyan
 */

@ExtendWith(MockitoExtension.class)
class VoteValidatorImplTest {

    @Mock
    private VoteValidator voteValidator;

    @Mock
    private VoteService voteService;

    @Mock
    private ElectorService electorService;

    @Mock
    private ElectionLocationService electionLocationService;

    @Mock
    private CandidateService candidateService;

    @BeforeEach
    void setUp() {
        voteValidator = new VoteValidatorImpl(voteService, electorService, electionLocationService, candidateService);
    }

    @Test
    void validateCreate_MissingElectorId() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        requestDto.setElectorId(null);
        requestDto.setCandidateId(1L);
        requestDto.setElectionLocationId(1L);
        Optional<ErrorType> errorType = voteValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_ELECTOR_ID);
    }

    @Test
    void validateCreate_MissingElectionLocationId() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        requestDto.setElectorId(1L);
        requestDto.setCandidateId(1L);
        requestDto.setElectionLocationId(null);
        Optional<ErrorType> errorType = voteValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_ELECTION_LOCATION_ID);
    }

    @Test
    void validateCreate_MissingCandidateId() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        requestDto.setElectorId(1L);
        requestDto.setCandidateId(null);
        requestDto.setElectionLocationId(1L);
        Optional<ErrorType> errorType = voteValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_CANDIDATE_ID);
    }

    @Test
    void validateCreate_ElectorNotFound() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        requestDto.setElectorId(1L);
        requestDto.setCandidateId(1L);
        requestDto.setElectionLocationId(1L);

        when(electorService.existsById(1L)).thenReturn(false);

        Optional<ErrorType> errorType = voteValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.ELECTOR_NOT_FOUND);
    }

    @Test
    void validateCreate_ElectionLocationNotFound() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        requestDto.setElectorId(1L);
        requestDto.setCandidateId(1L);
        requestDto.setElectionLocationId(1L);

        when(electionLocationService.existsById(1L)).thenReturn(false);

        Optional<ErrorType> errorType = voteValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.ELECTION_LOCATION_NOT_FOUND);
    }

    @Test
    void validateCreate_CandidateNotFound() {
        CreateVoteRequestDto requestDto = new CreateVoteRequestDto();
        requestDto.setElectorId(1L);
        requestDto.setCandidateId(1L);
        requestDto.setElectionLocationId(1L);

        when(candidateService.existsById(1L)).thenReturn(false);

        Optional<ErrorType> errorType = voteValidator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.CANDIDATE_NOT_FOUND);
    }

}