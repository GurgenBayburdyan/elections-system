package org.example.electionssystem.rest.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Elector;
import org.example.electionssystem.mapper.ElectorMapper;
import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ElectorDetailsDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.ElectorFacade;
import org.example.electionssystem.rest.facade.validator.ElectorValidator;
import org.example.electionssystem.service.ElectorService;
import org.example.electionssystem.service.params.CreateElectorParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Service
@Slf4j
@AllArgsConstructor
public class ElectorFacadeImpl implements ElectorFacade {

    private final ElectorService service;
    private final ElectorMapper mapper;
    private final ElectorValidator validator;

    @Override
    public List<ElectorDetailsDto> findAll() {
        log.info("Executing get all electors rest API");

        final List<Elector> electors = service.getAll();

        final List<ElectorDetailsDto> detailsDtos = mapper.toDetailsDtoList(electors);

        log.info("Successfully executed get all electors rest API, response - {}", detailsDtos);
        return detailsDtos;
    }

    @Override
    public ElectorDetailsDto create(CreateElectorRequestDto requestDto) {
        log.info("Executing create elector for the provided request to - {}:", requestDto);
        final Optional<ErrorType> optionalErrorType = validator.validateCreate(requestDto);

        if (optionalErrorType.isPresent()) {
            final ElectorDetailsDto detailsDto = new ElectorDetailsDto(optionalErrorType.get());
            log.info("Executing create elector failed, error-{}", optionalErrorType.get());
            return detailsDto;
        }

        final CreateElectorParams params=mapper.toCreateParams(requestDto);

        final Elector elector = service.create(params);

        final  ElectorDetailsDto detailsDto = mapper.toDetailsDto(elector);

        log.info("Successfully executed create elector rest API, response - {}", detailsDto);
        return detailsDto;
    }

    @Override
    public ElectorDetailsDto findByPassportNumber(String passportNumber) {
        log.info("Executing find elector by passport number - {}:", passportNumber);

        final Elector elector = service.getByPassportNumber(passportNumber);

        final ElectorDetailsDto detailsDto = mapper.toDetailsDto(elector);

        log.info("Successfully executed find elector by passport number rest API, response - {}", detailsDto);
        return detailsDto;
    }
}
