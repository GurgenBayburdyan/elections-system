package org.example.electionssystem.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Elector;
import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ElectorDetailsDto;
import org.example.electionssystem.service.params.CreateElectorParams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Component
public class ElectorMapper {

    public ElectorDetailsDto toDetailsDto(Elector elector) {
        log.trace("Mapping elector - {} to elector details dto", elector);

        final ElectorDetailsDto dto = new ElectorDetailsDto();
        dto.setFirstName(elector.getFirstName());
        dto.setLastName(elector.getLastName());
        dto.setDateOfBirth(elector.getDateOfBirth());

        log.trace("Mapped elector {}", dto);
        return dto;
    }

    public List<ElectorDetailsDto> toDetailsDtoList(List<Elector> electors) {
        final List<ElectorDetailsDto> dtos = new ArrayList<>();

        for (final Elector elector : electors) {
            dtos.add(toDetailsDto(elector));
        }

        return dtos;
    }

    public CreateElectorParams toCreateParams(CreateElectorRequestDto requestDto) {
        log.trace("Mapping create elector request dto - {} to create elector params", requestDto);

        final CreateElectorParams params = new CreateElectorParams(
                requestDto.getFirstName(),
                requestDto.getLastName(),
                requestDto.getDateOfBirth()
        );

        log.trace("Mapped create elector request dto {}", params);
        return params;
    }
}