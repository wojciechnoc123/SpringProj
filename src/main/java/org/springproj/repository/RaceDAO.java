package org.springproj.repository;

import java.util.List;
import org.springproj.model.GrandPrix;
import org.springproj.model.Season;
public interface RaceDAO {

    List<GrandPrix> findAll();

    List<GrandPrix> findBySeason(Season season);

    GrandPrix findByName(String name);
    GrandPrix findByCountry(String country);

}
