package org.example.electionssystem.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Candidate;
import org.example.electionssystem.repository.CandidateRepository;
import org.example.electionssystem.service.CandidateService;
import org.example.electionssystem.service.params.CreateCandidateParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Service
@AllArgsConstructor
class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Candidate> findAll() {
        log.debug("Executing get all candidates");

        List<Candidate> candidates = repository.findAll();

        log.debug("Successfully executed get all candidates, {}", candidates);
        return candidates;
    }

    @Override
    @Transactional
    public Candidate create(CreateCandidateParams params) {
//todo Assert.notNull(params, "
        log.debug("Executing create candidate, params-{}", params);

        final Candidate candidate = new Candidate();

        candidate.setFirstName(params.getFirstName());
        candidate.setLastName(params.getLastName());
        candidate.setNumber(params.getNumber());

        //todo please log the created candidate 
        log.debug("Successfully executed create candidate, {}", candidate);
        return repository.save(candidate);
    }

    @Override
    @Transactional(readOnly = true)
    public Candidate findById(Long id) {
        log.debug("Executing find candidate by id, id-{}", id);

        //todo please format the line
        Candidate candidate=repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Candidate not found") //todo please include id as well
        );

        log.debug("Successfully executed find candidate by id, {}", candidate);
        return candidate;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existsById(Long id) {
        //todo logs are missing
        return repository.existsById(id);
    }
}
