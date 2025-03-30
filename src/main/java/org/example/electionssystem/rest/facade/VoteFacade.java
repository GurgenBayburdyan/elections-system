package org.example.electionssystem.rest.facade;

import org.example.electionssystem.rest.dto.request.CreateVoteRequestDto;
import org.example.electionssystem.rest.dto.response.VoteDetailsDto;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface VoteFacade {

    List<VoteDetailsDto> findAll();

    VoteDetailsDto create(CreateVoteRequestDto requestDto);

}
