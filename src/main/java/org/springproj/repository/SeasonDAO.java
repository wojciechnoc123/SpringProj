package org.springproj.repository;

import org.springproj.model.Season;
import org.springproj.model.Race;

import java.util.List;

public interface SeasonDAO {

    Season findByYear(String year);

    Season findByRace(Race race);

    List<Season> findAll();


}
