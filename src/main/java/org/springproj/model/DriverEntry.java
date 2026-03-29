package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DriverEntry {

    private int id;
    private Driver driver;
    private TeamEntry team;
    private int number;
    private Season season;

    public DriverEntry(int id, Driver driver, TeamEntry teamEntry, int number, Season season) {
        this.id = id;
        this.driver = driver;
        this.team = teamEntry;
        this.number = number;
        this.season = season;
    }

    public DriverEntry(int id, Driver driver, TeamEntry teamEntry, int number) {
        this(id, driver, teamEntry, number, teamEntry.getSeason());
    }

    public DriverEntry(int id, Driver driver, int number) {
        this(id, driver, null, number, null);
    }

    public DriverEntry() {}

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setTeam(TeamEntry team) {
        this.team = team;
    }
    @JsonIgnore
    public TeamEntry getTeam() {
        return this.team;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        }
    }
    public int getNumber() {
        return this.number;
    }

    public Season getSeason() {
        return this.season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
