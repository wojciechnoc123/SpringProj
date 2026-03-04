package org.springproj.repository;

import org.springproj.model.Team;
import org.springproj.model.Driver;

import java.util.List;


public interface TeamDAO {

    Team findByDriver(Driver driver);

    List<Team> findAll();

}
