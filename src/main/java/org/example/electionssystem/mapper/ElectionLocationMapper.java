package org.example.electionssystem.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ElectionLocationDetailsDto;
import org.example.electionssystem.service.params.CreateElectionLocationParams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Component
public class ElectionLocationMapper {

    public ElectionLocationDetailsDto toDetailsDto(ElectionLocation electionLocation) {
        log.trace("Mapping election location - {} to election location details dto", electionLocation);

        final ElectionLocationDetailsDto dto = new ElectionLocationDetailsDto();
        dto.setId(electionLocation.getId());
        dto.setAddress(electionLocation.getAddress());

        log.trace("Mapped election location {}", dto);
        return dto;
    }

    public List<ElectionLocationDetailsDto> toDetailsDtoList(List<ElectionLocation> electionLocations) {
        final List<ElectionLocationDetailsDto> dtos = new ArrayList<>();

        for (final ElectionLocation electionLocation : electionLocations) {
            dtos.add(toDetailsDto(electionLocation));
        }

        return dtos;
    }

    public CreateElectionLocationParams toCreateParams(CreateElectionLocationRequestDto requestDto) {
        log.trace("Mapping create election location request dto - {} to create election location params", requestDto);

        final CreateElectionLocationParams params = new CreateElectionLocationParams(
                requestDto.getAddress()
        );

        log.trace("Mapped create election location request dto {}", params);
        return params;
    }
}

