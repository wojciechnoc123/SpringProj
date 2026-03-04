package org.springproj.repository.sampleMem;

import org.springproj.model.Driver;
import org.springproj.model.Team;
import org.springproj.repository.TeamDAO;

import java.util.List;

public class MemTeamDao implements TeamDAO {

    @Override
    public Team findByDriver(Driver driver) {
        for (var x : SampleData.sampleTeams) {
            for (var d : x.getDrivers()) {
                if (d.equals(driver))
                    return x;
            }
        }
        return null;
    }

    @Override
    public List<Team> findAll() {
        return SampleData.sampleTeams;
    }



}
