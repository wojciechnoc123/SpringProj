package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springproj.model.Driver;
import org.springproj.model.Team;
import org.springproj.repository.TeamDAO;

import java.util.List;

@Component
public class MemTeamDao implements TeamDAO {

        @Override
        public Team findByName(String name) {
            return null;
        }

    @Override
    public List<Team> findAll() {
        return SampleData.sampleTeams;
    }



}
