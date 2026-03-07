package org.springproj.repository;

import org.springproj.model.Season;
import org.springproj.model.GrandPrix;

import java.util.List;

public interface SeasonDAO {

    Season findByYear(String year);

    Season findByRace(GrandPrix grandPrix);

    List<Season> findAll();


}
