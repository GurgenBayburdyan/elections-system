package org.example.electionssystem.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.Elector;
import org.example.electionssystem.repository.ElectorRepository;
import org.example.electionssystem.service.ElectorService;
import org.example.electionssystem.service.params.CreateElectorParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Service
@AllArgsConstructor
class ElectorServiceImpl implements ElectorService {

    private final ElectorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Elector> findAll() {
        log.debug("Executing get all electors");

        List<Elector> electors = repository.findAll();

        log.debug("Successfully executed get all electors, {}", electors);
        return electors;
    }

    @Override
    @Transactional
    public Elector create(CreateElectorParams params) {
        log.debug("Executing create elector, params-{}", params);

        final Elector elector = new Elector();

        elector.setFirstName(params.getFirstName());
        elector.setLastName(params.getLastName());
        elector.setDateOfBirth(params.getDateOfBirth());

        log.debug("Successfully executed create elector, {}", elector);
        return repository.save(elector);
    }

    @Override
    @Transactional(readOnly = true)
    public Elector findById(Long id) {
        log.debug("Executing find elector by id, id-{}", id);

        Elector elector = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Elector not found")
        );

        log.debug("Successfully executed find candidate by id, {}", elector);
        return elector;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
