package org.springproj.repository;

import org.springproj.model.Team;
import org.springproj.model.Driver;

import java.util.List;


public interface TeamDAO {

    Team findByName(String name);

    List<Team> findAll();

    Team findById(int id);

    Team saveTeam(Team team);

}
