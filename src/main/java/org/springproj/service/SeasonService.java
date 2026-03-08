package org.springproj.service;

import org.springproj.model.Season;
import java.util.List;
import org.springproj.model.GrandPrix;

public interface SeasonService {

    List<Season> findAll();

    Season findById(int id);

    Season findByYear(String year);

    Season findByRace(GrandPrix gp);

}
