package org.springproj.service.impl;

import org.springframework.stereotype.Component;
import org.springproj.model.Driver;
import org.springproj.model.Season;
import org.springproj.model.Team;
import org.springproj.repository.DriverDAO;
import org.springproj.repository.SeasonDAO;
import org.springproj.repository.TeamDAO;
import org.springproj.service.SeasonService;
import java.util.List;


@Component
public class SeasonServiceBean implements SeasonService {

    private SeasonDAO seasonDao;
    private TeamDAO teamDao;
    private DriverDAO driverDAO;

    //autowired gdyby wiecej konstruktorow
    //@Autowired
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
                System.out.println(r.getName());
                System.out.println(r.showResults());
            }
        }
    }

    @Override
    public String printAllSeasonsString() {
        StringBuilder output = new StringBuilder();
        for (var x : seasonDao.findAll()) {
            output.append("Season ");
            output.append(x.getYear());
            output.append("\n");
            for (var r : x.getRaces()) {
                output.append(r.getName());
                output.append("\n");
                output.append(r.showResults());
                output.append("<br>");
            }
        }
        return String.valueOf(output);
    }

    @Override
    public List<Season> getAllSeasons() {
        return seasonDao.findAll();
    }

    public List<Driver> getAllDrivers() {
        return driverDAO.findAll();
    }

    public void setSeasonDao(SeasonDAO seasonDao) {
        this.seasonDao = seasonDao;
    }

    public SeasonDAO getSeasonDao(SeasonDAO seasonDao) {
        return this.seasonDao;
    }

    public void setTeamDao(TeamDAO teamDao) {
        this.teamDao = teamDao;
    }

    public TeamDAO getTeamDao() {
        return this.teamDao;
    }

    public void setDriverDAO(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    public DriverDAO getDriverDAO() {
        return this.driverDAO;
    }


}
