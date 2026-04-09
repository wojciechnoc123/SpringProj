package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springproj.model.DriverEntry;
import org.springproj.model.TeamEntry;
import org.springproj.repository.TeamEntryDao;

import java.util.List;

@Repository
@Primary
public class JpaTeamEntryDao implements TeamEntryDao {

    private final TeamEntryJpaRepository teamEntryRepository;

    public JpaTeamEntryDao(TeamEntryJpaRepository teamEntryRepository) {
        this.teamEntryRepository = teamEntryRepository;
    }

    @Override
    public List<TeamEntry> findAll() {
        return this.teamEntryRepository.findAll();
    }

    @Override
    public TeamEntry findById(int id) {
        return this.teamEntryRepository.findById(id).orElse(null);
    }

    @Override
    public TeamEntry findByDriverEntry(DriverEntry driverEntry) {
        if (driverEntry == null) {
            return null;
        }
        return this.teamEntryRepository.findByRaceDrivers_Id(driverEntry.getId()).orElse(null);
    }
}
