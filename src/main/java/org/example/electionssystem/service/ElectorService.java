package org.example.electionssystem.service;

import org.example.electionssystem.entity.Elector;
import org.example.electionssystem.service.params.CreateElectorParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

public interface ElectorService {

    List<Elector> getAll();

    Elector create(CreateElectorParams params);

    Elector getById(Long id);

    Boolean existsById(Long id);

    Elector getByPassportNumber(String passportNumber);

}
