package org.springproj.service;

import org.springproj.model.*;

import java.util.List;

public interface GeneralService {

    public void printAllSeasons();

    public String printAllSeasonsString();

    public List<Season> getAllSeasons();

    public List<Driver> getAllDrivers();

    public List<DriverEntry> getAllDriverEntries();

    public List<TeamEntry> getAllTeamEntries();

    public List<Team> getAllTeams();

    public List<Engine> getAllEngines();

    public List<EngineSupplier> getAllEnginesSuppliers();

    public Season getSeasonById(int id);

}
