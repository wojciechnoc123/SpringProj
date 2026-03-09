package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.model.Driver;
import org.springproj.model.Team;
import org.springproj.repository.TeamDAO;

import java.util.List;

@Repository("teamDao")
public class MemTeamDao implements TeamDAO {

        @Override
        public Team findByName(String name) {
            return null;
        }

    @Override
    public List<Team> findAll() {
        return SampleData.sampleTeams;
    }

    @Override
    public Team findById(int id) {
    //well potrzebuje do zadania nulla a tu mi zwroci NPE
    //        return SampleData.sampleTeams.stream().filter((x -> x.getId() == id)).findFirst().get();
        for (var x : SampleData.sampleTeams) {
            if (x.getId() == id)
                return x;
        }
        return null;
    }



}
