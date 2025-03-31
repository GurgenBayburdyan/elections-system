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
import org.springframework.util.Assert;

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
    public List<Candidate> getAll() {
        log.debug("Executing get all candidates");

        final List<Candidate> candidates = repository.findAll();

        log.debug("Successfully executed get all candidates, {}", candidates);
        return candidates;
    }

    @Override
    @Transactional
    public Candidate create(CreateCandidateParams params) {
        Assert.notNull(params, "the params must not be null");
        log.debug("Executing create candidate, params-{}", params);

        final Candidate candidate = new Candidate();

        candidate.setFirstName(params.getFirstName());
        candidate.setLastName(params.getLastName());
        candidate.setNumber(params.getNumber());

        final Candidate saved = repository.save(candidate);
        log.debug("Successfully executed create candidate, {}", saved);
        return saved;
    }

    @Override
    @Transactional(readOnly = true)
    public Candidate getById(Long id) {
        log.debug("Executing find candidate by id, id-{}", id);

        final Candidate candidate = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Candidate not found with id: " + id)
        );


        log.debug("Successfully executed find candidate by id, {}", candidate);
        return candidate;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existsById(Long id) {
        log.debug("Executing exists candidate by id, id-{}", id);

        final Boolean response = repository.existsById(id);

        log.debug("Successfully executed exists candidate by id, {}", response);
        return response;
    }
}
