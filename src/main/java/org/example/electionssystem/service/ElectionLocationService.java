package org.example.electionssystem.service;

import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.service.params.CreateElectionLocationParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface ElectionLocationService {

    List<ElectionLocation> getAll();

    ElectionLocation create(CreateElectionLocationParams params);

    ElectionLocation getById(Long id);

    Boolean existsById(Long id);

}
