package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team_entry")
public class TeamEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;
    @Column(name = "chassis_name")
    private String chassisName;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    //private DriverEntry[] raceDrivers = new DriverEntry[2];

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<DriverEntry> raceDrivers = new ArrayList<>(2);

    public TeamEntry(int i, Team team, Engine engine, String chassisName, Season season) {
        this.id = i;
        this.team = team;
        this.engine = engine;
        this.chassisName = chassisName;
        this.season = season;
    }

    public TeamEntry(int i, Team team, Engine engine, String chassisName, Season season, DriverEntry driver1, DriverEntry driver2) {
        this(i, team, engine, chassisName, season);
        this.raceDrivers.add(driver1);
        this.raceDrivers.add(driver2);
    }

    public TeamEntry(int i, Team team, Engine engine, String chassisName) {
        this(i, team, engine, chassisName, null);
    }

    public TeamEntry(int i, Team team, Engine engine, String chassisName, DriverEntry driver1, DriverEntry driver2) {
        this(i, team, engine, chassisName, null);
        this.raceDrivers.add(driver1);
        this.raceDrivers.add(driver2);
    }

    public TeamEntry() {}

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
        if (!(this.raceDrivers.isEmpty()))
            this.raceDrivers.set(0, driver);
        else
            this.raceDrivers.add(driver);
    }

    public void setSecondDriver(DriverEntry driver) {
        if (this.raceDrivers.size() < 2)
            this.raceDrivers.add(driver);
        else    //maybe change to better requirement
            this.raceDrivers.set(1, driver);
    }

    public DriverEntry getFirstDriver() {
        if (!(this.raceDrivers.isEmpty()))
            return this.raceDrivers.get(0);
        else
            return null;
    }

    public DriverEntry getSecondDriver() {
        if (!(this.raceDrivers.size() < 2))
            return this.raceDrivers.get(1);
        else
            return null;
    }

    @JsonIgnore
    public List<DriverEntry> getRaceDrivers() {
        return this.raceDrivers;
    }

    public void setRaceDrivers(DriverEntry driver1, DriverEntry driver2) {
        setFirstDriver(driver1);
        setSecondDriver(driver2);
    }

    @JsonIgnore
    public Season getSeason() {
        return this.season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

}
