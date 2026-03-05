package org.springproj.service;

import org.springproj.model.Driver;
import org.springproj.model.Season;
import java.util.List;

public interface SeasonService {

    public void printAllSeasons();

    public String printAllSeasonsString();

    public List<Season> getAllSeasons();

    public List<Driver> getAllDrivers();

}
