package org.example.electionssystem.service;

import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.service.params.CreateElectionLocationParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface ElectionLocationService {

    List<ElectionLocation> findAll();

    ElectionLocation create(CreateElectionLocationParams params);

    ElectionLocation findById(Long id);

    Boolean existsById(Long id);

}
