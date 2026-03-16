package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springproj.repository.TeamDAO;
import org.springproj.service.TeamService;
import org.springproj.model.Team;
import java.util.List;

@Component
@Scope("prototype")
public class TeamServiceBean implements TeamService {

    private final TeamDAO teamDAO;

    public TeamServiceBean(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    public List<Team> findAll() {
        return this.teamDAO.findAll();
    }

    @Override
    public Team findById(int id) {
        return this.teamDAO.findById(id);
    }

    @Override
    public Team findByName(String name) {
        return this.teamDAO.findByName(name);

    }
    //do dodania znajdywanie by country
    @Override
    public List<Team> findByCountry(String country) {
        return null;
    }

    @Override
    public Team saveTeam(Team team) {
        return this.teamDAO.saveTeam(team);
    }

}
