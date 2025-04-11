package org.example.electionssystem.rest.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Candidate;
import org.example.electionssystem.mapper.CandidateMapper;
import org.example.electionssystem.rest.dto.request.CreateCandidateRequestDto;
import org.example.electionssystem.rest.dto.response.CandidateDetailsDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.CandidateFacade;
import org.example.electionssystem.rest.facade.validator.CandidateValidator;
import org.example.electionssystem.service.CandidateService;
import org.example.electionssystem.service.params.CreateCandidateParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Service
@Slf4j
@AllArgsConstructor
public class CandidateFacadeImpl implements CandidateFacade {

    private final CandidateService service;
    private final CandidateMapper mapper;
    private final CandidateValidator validator;

    @Override
    public List<CandidateDetailsDto> findAll() {
        log.info("Executing get all candidates rest API");

        final List<Candidate> candidates = service.getAll();

        final List<CandidateDetailsDto> detailsDtos = mapper.toDetailsDtoList(candidates);

        log.info("Successfully executed get all candidates rest API, response - {}", detailsDtos);
        return detailsDtos;
    }

    @Override
    public CandidateDetailsDto create(CreateCandidateRequestDto requestDto) {
        log.info("Executing create candidate for the provided request to - {}:", requestDto);

        final Optional<ErrorType> optionalErrorType = validator.validateCreate(requestDto);

        if (optionalErrorType.isPresent()) {
            final CandidateDetailsDto detailsDto = new CandidateDetailsDto(optionalErrorType.get());
            log.info("Executing create candidate failed, error-{}", optionalErrorType.get());
            return detailsDto;
        }

        final CreateCandidateParams params=mapper.toCreateParams(requestDto);

        final Candidate candidate = service.create(params);

        final CandidateDetailsDto detailsDto = mapper.toDetailsDto(candidate);

        log.info("Successfully executed create candidate rest API, response - {}", detailsDto);
        return detailsDto;
    }
}
