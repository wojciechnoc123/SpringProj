package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.TeamEntry;

import java.util.Optional;

public interface TeamEntryJpaRepository extends JpaRepository<TeamEntry, Integer> {

    Optional<TeamEntry> findByRaceDrivers_Id(Integer driverEntryId);
}
