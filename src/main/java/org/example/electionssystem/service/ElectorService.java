package org.example.electionssystem.service;

import org.example.electionssystem.entity.Elector;
import org.example.electionssystem.service.params.CreateElectorParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

public interface ElectorService {

    List<Elector> findAll();

    Elector create(CreateElectorParams params);

    Elector findById(Long id);

    Boolean existsById(Long id);

}
