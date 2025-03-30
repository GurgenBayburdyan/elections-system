package org.example.electionssystem.repository;

import org.example.electionssystem.entity.ElectionLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gurgen Bayburdyan
 */

@Repository
public interface ElectionLocationRepository extends JpaRepository<ElectionLocation, Long> {
}
