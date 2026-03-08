package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springproj.model.*;
import org.springproj.repository.*;
import org.springproj.service.GeneralService;
import java.util.List;


@Service
@Scope("prototype")
public class GeneralServiceBean implements GeneralService {

    private SeasonDAO seasonDao;
    private TeamDAO teamDao;
    private DriverDAO driverDAO;
    private DriverEntryDao driverEntryDao;
    private TeamEntryDao teamEntryDao;
    private EngineDao engineDao;
    private EngineSupplierDao engineSupplierDao;

    //autowired gdyby wiecej konstruktorow
    //@Autowired
    public GeneralServiceBean(SeasonDAO seasonDao, TeamDAO teamDao, DriverDAO driverDAO, DriverEntryDao driverEntryDao, TeamEntryDao teamEntryDao, EngineDao engineDao, EngineSupplierDao engineSupplierDao) {
        this.seasonDao = seasonDao;
        this.teamDao = teamDao;
        this.driverDAO = driverDAO;
        this.driverEntryDao = driverEntryDao;
        this.teamEntryDao = teamEntryDao;
        this.engineDao = engineDao;
        this.engineSupplierDao = engineSupplierDao;
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

    @Override
    public void printAllSeasons() {
        for (var x : seasonDao.findAll()) {
            System.out.println("Season " + x.getYear());
            for (var r : x.getGrandPrixes()) {
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
            for (var r : x.getGrandPrixes()) {
                output.append(r.getName());
                output.append(" ");
                output.append(r.getCircuit().getName());
                output.append("\n");
                output.append(r.showResults());
                output.append("\n");
            }
        }
        return String.valueOf(output);
    }

    @Override
    public List<Season> getAllSeasons() {
        return seasonDao.findAll();
    }

    @Override
    public Season getSeasonById(int id) {
        return seasonDao.findById(id);
    }

    @Override
    public List<DriverEntry> getAllDriverEntries() {
        return this.driverEntryDao.findAll();
    }

    @Override
    public List<TeamEntry> getAllTeamEntries() {
        return this.teamEntryDao.findAll();
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDAO.findAll();
    }

    @Override
    public List<Team> getAllTeams() {
        return teamDao.findAll();
    }

    @Override
    public List<Engine> getAllEngines() {
        return engineDao.findAll();
    }

    @Override
    public List<EngineSupplier> getAllEnginesSuppliers() {
        return engineSupplierDao.findAll();
    }




}
