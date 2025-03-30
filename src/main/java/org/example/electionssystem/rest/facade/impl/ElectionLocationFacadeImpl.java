package org.example.electionssystem.rest.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.mapper.ElectionLocationMapper;
import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ElectionLocationDetailsDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.ElectionLocationFacade;
import org.example.electionssystem.rest.facade.validator.ElectionLocationValidator;
import org.example.electionssystem.service.ElectionLocationService;
import org.example.electionssystem.service.params.CreateElectionLocationParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Service
@Slf4j
@AllArgsConstructor
public class ElectionLocationFacadeImpl implements ElectionLocationFacade {

    private final ElectionLocationService service;
    private final ElectionLocationMapper mapper;
    private final ElectionLocationValidator validator;

    @Override
    public List<ElectionLocationDetailsDto> findAll() {
        log.info("Executing get all election location rest API");

        final List<ElectionLocation> electionLocations = service.findAll();

        final List<ElectionLocationDetailsDto> detailsDtos = mapper.toDetailsDtoList(electionLocations);

        log.info("Successfully executed get all election locations rest API, response - {}", detailsDtos);
        return detailsDtos;
    }

    @Override
    public ElectionLocationDetailsDto create(CreateElectionLocationRequestDto requestDto) {
        log.info("Executing create elector for the provided request to - {}:", requestDto);
        final Optional<ErrorType> optionalErrorType = validator.validateCreate(requestDto);

        if (optionalErrorType.isPresent()) {
            final ElectionLocationDetailsDto detailsDto = new ElectionLocationDetailsDto(optionalErrorType.get());
            log.info("Executing create election location failed, error-{}", optionalErrorType.get());
            return detailsDto;
        }

        final CreateElectionLocationParams params = mapper.toCreateParams(requestDto);

        final ElectionLocation electionLocation = service.create(params);

        final ElectionLocationDetailsDto detailsDto = mapper.toDetailsDto(electionLocation);

        log.info("Successfully executed create election location rest API, response - {}", detailsDto);
        return detailsDto;
    }

}
