package org.example.electionssystem.rest.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Vote;
import org.example.electionssystem.mapper.VoteMapper;
import org.example.electionssystem.rest.dto.request.CreateVoteRequestDto;
import org.example.electionssystem.rest.dto.response.VoteDetailsDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.VoteFacade;
import org.example.electionssystem.rest.facade.validator.VoteValidator;
import org.example.electionssystem.service.VoteService;
import org.example.electionssystem.service.params.CreateVoteParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Service
@Slf4j
@AllArgsConstructor
public class VoteFacadeImpl implements VoteFacade {

    private final VoteService service;
    private final VoteMapper mapper;
    private final VoteValidator validator;

    @Override
    public List<VoteDetailsDto> findAll() {
        log.info("Executing get all votes rest API");

        final List<Vote> votes = service.findAll();

        final List<VoteDetailsDto> detailsDtos = mapper.toDetailsDtoList(votes);

        log.info("Successfully executed get all votes rest API, response - {}", detailsDtos);
        return detailsDtos;
    }

    @Override
    public VoteDetailsDto create(CreateVoteRequestDto requestDto) {
        log.info("Executing create vote for the provided request to - {}:", requestDto);
        final Optional<ErrorType> optionalErrorType = validator.validateCreate(requestDto);

        if (optionalErrorType.isPresent()) {
            final VoteDetailsDto detailsDto = new VoteDetailsDto(optionalErrorType.get());
            log.info("Executing create vote failed, error-{}", optionalErrorType.get());
            return detailsDto;
        }

        final CreateVoteParams params=mapper.toCreateParams(requestDto);

        final Vote vote = service.create(params);

        final VoteDetailsDto detailsDto = mapper.toDetailsDto(vote);

        log.info("Successfully executed create vote rest API, response - {}", detailsDto);
        return detailsDto;
    }
}
