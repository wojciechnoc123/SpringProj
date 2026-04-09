package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "driver_entry")
public class DriverEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "team_entry_id")
    private TeamEntry team;
    private int number;
    @Transient
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
        this.season = team != null ? team.getSeason() : null;
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
        if (this.season != null) {
            return this.season;
        }
        return this.team != null ? this.team.getSeason() : null;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
