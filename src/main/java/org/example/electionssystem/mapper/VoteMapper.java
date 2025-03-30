package org.example.electionssystem.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Vote;
import org.example.electionssystem.rest.dto.request.*;
import org.example.electionssystem.rest.dto.response.VoteDetailsDto;
import org.example.electionssystem.service.params.CreateVoteParams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Component
public class VoteMapper {

    public VoteDetailsDto toDetailsDto(Vote vote) {
        log.trace("Mapping vote - {} to vote details dto", vote);

        final VoteDetailsDto dto = new VoteDetailsDto();
        dto.setCandidateId(vote.getCandidate().getId());
        dto.setElectorId(vote.getElector().getId());
        dto.setElectionLocationId(vote.getElectionLocation().getId());

        log.trace("Mapped vote {}", dto);
        return dto;
    }

    public List<VoteDetailsDto> toDetailsDtoList(List<Vote> votes) {
        final List<VoteDetailsDto> dtos = new ArrayList<>();

        for (Vote vote : votes) {
            dtos.add(toDetailsDto(vote));
        }

        return dtos;
    }

    public CreateVoteParams toCreateParams(CreateVoteRequestDto requestDto) {
        log.trace("Mapping create vote request dto - {} to create vote params", requestDto);

        final CreateVoteParams params = new CreateVoteParams(
                requestDto.getElectorId(),
                requestDto.getElectionLocationId(),
                requestDto.getCandidateId()
        );

        log.trace("Mapped create vote request dto {}", params);
        return params;
    }
}