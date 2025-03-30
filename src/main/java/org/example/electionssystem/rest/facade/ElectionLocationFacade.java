package org.example.electionssystem.rest.facade;

import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ElectionLocationDetailsDto;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface ElectionLocationFacade {

    List<ElectionLocationDetailsDto> findAll();

    ElectionLocationDetailsDto create(CreateElectionLocationRequestDto requestDto);

}
