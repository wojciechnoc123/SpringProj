package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeamEntry {

    private int id;
    private Team team;
    private Engine engine;
    private String chassisName;

    private DriverEntry[] raceDrivers = new DriverEntry[2];

    public TeamEntry(int i, Team team, Engine engine, String chassisName) {
        this.id = i;
        this.team = team;
        this.engine = engine;
        this.chassisName = chassisName;
    }

    public TeamEntry(int i, Team team, Engine engine, String chassisName, DriverEntry driver1, DriverEntry driver2) {
        this(i, team, engine, chassisName);
        this.raceDrivers[0] = driver1;
        this.raceDrivers[1] = driver2;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getChassisName() {
        return this.chassisName;
    }

    public void setChassisName(String chassisName) {
        this.chassisName = chassisName;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public void setFirstDriver(DriverEntry driver) {
        this.raceDrivers[0] = driver;
    }

    public void setSecondDriver(DriverEntry driver) {
        this.raceDrivers[1] = driver;
    }

    public DriverEntry getFirstDriver() {
        return this.raceDrivers[0];
    }

    public DriverEntry getSecondDriver() {
        return this.raceDrivers[1];
    }

    @JsonIgnore
    public DriverEntry[] getRaceDrivers() {
        return this.raceDrivers;
    }

    public void setRaceDrivers(DriverEntry driver1, DriverEntry driver2) {
        setFirstDriver(driver1);
        setSecondDriver(driver2);
    }

}
