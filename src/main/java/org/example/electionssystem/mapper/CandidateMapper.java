package org.example.electionssystem.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Candidate;
import org.example.electionssystem.rest.dto.request.CreateCandidateRequestDto;
import org.example.electionssystem.rest.dto.response.CandidateDetailsDto;
import org.example.electionssystem.service.params.CreateCandidateParams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Component
public class CandidateMapper {

    public CandidateDetailsDto toDetailsDto(Candidate candidate) {
        log.trace("Mapping candidate - {} to candidate details dto", candidate);

        final CandidateDetailsDto dto = new CandidateDetailsDto();
        dto.setId(candidate.getId());
        dto.setFirstName(candidate.getFirstName());
        dto.setLastName(candidate.getLastName());
        dto.setNumber(candidate.getNumber());

        log.trace("Mapped candidate {}", dto);
        return dto;
    }

    public List<CandidateDetailsDto> toDetailsDtoList(List<Candidate> candidates) {
        final List<CandidateDetailsDto> dtos = new ArrayList<>();

        for (final Candidate candidate : candidates) {
            dtos.add(toDetailsDto(candidate));
        }

        return dtos;
    }

    public CreateCandidateParams toCreateParams(CreateCandidateRequestDto requestDto) {
        log.trace("Mapping create candidate request dto - {} to create candidate params", requestDto);

        final CreateCandidateParams params=new CreateCandidateParams(
                requestDto.getFirstName(),
                requestDto.getLastName(),
                requestDto.getNumber()
        );

        log.trace("Mapped create candidate request dto {}", params);
        return params;
    }
}