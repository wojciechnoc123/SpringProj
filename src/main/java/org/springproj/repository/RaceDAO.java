package org.springproj.repository;

import java.util.List;
import org.springproj.model.Race;
import org.springproj.model.Season;
public interface RaceDAO {

    List<Race> findAll();

    List<Race> findBySeason(Season season);

    Race findByName(String name);
    Race findByCountry(String country);

}
