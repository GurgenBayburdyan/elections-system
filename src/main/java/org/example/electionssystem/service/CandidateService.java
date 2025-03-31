package org.example.electionssystem.service;

import org.example.electionssystem.entity.Candidate;
import org.example.electionssystem.service.params.CreateCandidateParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface CandidateService {

    List<Candidate> getAll();

    Candidate create(CreateCandidateParams params);

    Candidate getById(Long id);

    Boolean existsById(Long id);

}
