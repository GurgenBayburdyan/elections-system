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
import org.springframework.util.Assert;

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
    public List<Elector> getAll() {
        log.debug("Executing get all electors");

        List<Elector> electors = repository.findAll();

        log.debug("Successfully executed get all electors, {}", electors);
        return electors;
    }

    @Override
    @Transactional
    public Elector create(CreateElectorParams params) {
        Assert.notNull(params, "the params must not be null");
        log.debug("Executing create elector, params-{}", params);

        final Elector elector = new Elector();

        elector.setFirstName(params.getFirstName());
        elector.setLastName(params.getLastName());
        elector.setDateOfBirth(params.getDateOfBirth());
        elector.setPassportNumber(params.getPassportNumber());

        Elector saved = repository.save(elector);
        log.debug("Successfully executed create elector, {}", saved);
        return saved;
    }

    @Override
    @Transactional(readOnly = true)
    public Elector getById(Long id) {
        log.debug("Executing find elector by id, id-{}", id);

        Elector elector = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Elector not found with id: " + id)
        );

        log.debug("Successfully executed find elector by id, {}", elector);
        return elector;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existsById(Long id) {
        log.debug("Executing exists elector by id, id-{}", id);

        final Boolean response = repository.existsById(id);

        log.debug("Successfully executed exists elector by id, {}", response);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public Elector getByPassportNumber(String passportNumber) {
        log.debug("Executing find elector by passport number, passport number-{}", passportNumber);

        Elector elector = repository.findByPassportNumber(((passportNumber)));

        log.debug("Successfully executed find elector by passport number, {}", elector);
        return elector;
    }
}
