package org.example.electionssystem.rest.facade;

import org.example.electionssystem.rest.dto.request.CreateCandidateRequestDto;
import org.example.electionssystem.rest.dto.response.CandidateDetailsDto;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

public interface CandidateFacade {

    List<CandidateDetailsDto> findAll();

    CandidateDetailsDto create(CreateCandidateRequestDto requestDto);

}
