package org.springproj.service.impl;

import org.springproj.model.Season;
import org.springproj.model.Team;
import org.springproj.repository.DriverDAO;
import org.springproj.repository.SeasonDAO;
import org.springproj.repository.TeamDAO;
import org.springproj.service.SeasonService;
import java.util.List;

public class SeasonServiceBean implements SeasonService {

    private SeasonDAO seasonDao;
    private TeamDAO teamDao;
    private DriverDAO driverDAO;

    public SeasonServiceBean(SeasonDAO seasonDao, TeamDAO teamDao, DriverDAO driverDAO) {
        this.seasonDao = seasonDao;
        this.teamDao = teamDao;
        this.driverDAO = driverDAO;
    }

    @Override
    public void printAllSeasons() {
        for (var x : seasonDao.findAll()) {
            System.out.println("Season " + x.getYear());
            for (var r : x.getRaces()) {
                System.out.println(r.showResults());
            }
        }
    }


}
