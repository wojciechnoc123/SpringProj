package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.model.DriverEntry;
import org.springproj.model.TeamEntry;
import org.springproj.repository.TeamEntryDao;

import java.util.List;

@Repository("teamEntryDao")
public class MemTeamEntryDao implements TeamEntryDao {


    @Override
    public List<TeamEntry> findAll() {
        return SampleData.sampleTeamEntries;
    }

    @Override
    public TeamEntry findById(int id) {
        return SampleData.sampleTeamEntries.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public TeamEntry findByDriverEntry(DriverEntry driverEntry) {
        return SampleData.sampleTeamEntries.stream().filter(x -> x.getFirstDriver().equals(driverEntry) || x.getSecondDriver().equals(driverEntry)).findFirst().get();
    }

}
