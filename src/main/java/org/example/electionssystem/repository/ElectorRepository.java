package org.example.electionssystem.repository;

import org.example.electionssystem.entity.Elector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gurgen Bayburdyan
 */

@Repository
public interface ElectorRepository extends JpaRepository<Elector, Long> {
}
