package org.springproj.service;

import org.springproj.model.Team;
import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team findById(int id);

    Team findByName(String name);

    List<Team> findByCountry(String country);

}
