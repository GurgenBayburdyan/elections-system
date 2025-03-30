package org.example.electionssystem.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.repository.ElectionLocationRepository;
import org.example.electionssystem.service.ElectionLocationService;
import org.example.electionssystem.service.params.CreateElectionLocationParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Service
@AllArgsConstructor
class ElectionLocationServiceImpl implements ElectionLocationService {

    private final ElectionLocationRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ElectionLocation> findAll() {
        log.debug("Executing get all election locations");

        List<ElectionLocation> electionLocations = repository.findAll();

        log.debug("Successfully executed get all election locations, {}", electionLocations);
        return electionLocations;
    }

    @Override
    @Transactional
    public ElectionLocation create(CreateElectionLocationParams params) {
        log.debug("Executing create election location, params-{}", params);

        final ElectionLocation electionLocation = new ElectionLocation();

        electionLocation.setAddress(params.getAddress());

        log.debug("Successfully executed create elector, {}", electionLocation);
        return repository.save(electionLocation);
    }

    @Override
    @Transactional(readOnly = true)
    public ElectionLocation findById(Long id) {
        log.debug("Executing find election location by id, id-{}", id);

        ElectionLocation electionLocation=repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Election location not found")
        );

        log.debug("Successfully executed find election location by id, {}", electionLocation);
        return electionLocation;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
