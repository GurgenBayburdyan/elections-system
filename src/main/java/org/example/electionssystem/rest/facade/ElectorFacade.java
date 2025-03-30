package org.example.electionssystem.rest.facade;

import org.example.electionssystem.rest.dto.request.CreateElectorRequestDto;
import org.example.electionssystem.rest.dto.response.ElectorDetailsDto;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface ElectorFacade {

    List<ElectorDetailsDto> findAll();

    ElectorDetailsDto create(CreateElectorRequestDto requestDto);

}
