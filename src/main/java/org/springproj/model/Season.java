package org.springproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String year;


    @Transient
    private List<DriverEntry> drivers = new ArrayList<>();

    @OneToMany(mappedBy = "season", fetch = FetchType.EAGER)
    private List<TeamEntry> teams = new ArrayList<>();

    @OneToMany(mappedBy = "season", fetch = FetchType.EAGER)
    private List<GrandPrix> grandPrixes = new ArrayList<>();

    public Season(int id, String year, List<GrandPrix> grandPrixes, List<DriverEntry> drivers, List<TeamEntry> teams) {
        this.id = id;
        this.year = year;
        this.grandPrixes = grandPrixes;
        this.teams = teams;
        this.drivers = drivers;
    }

    public Season(int it, String year) {
        this(it, year,new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Season() {}

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getYear() {
        return this.year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public List<GrandPrix> getGrandPrixes() {
        return this.grandPrixes;
    }

    public GrandPrix getRace(int i) {
        if (i < this.grandPrixes.size())
            return this.grandPrixes.get(i);
        else
            return this.grandPrixes.get(this.grandPrixes.size() - 1);
    }

    public void setGrandPrixList(List<GrandPrix> grandPrixes) {
        this.grandPrixes = grandPrixes;
    }

    public void addGrandPrix(GrandPrix grandPrix) {
        this.grandPrixes.add(grandPrix);
    }

    public void setGrandPrix(int i, GrandPrix grandPrix) {
        this.grandPrixes.set(i-1, grandPrix);
    }

    public List<DriverEntry> getDrivers() {
        if ((this.drivers == null || this.drivers.isEmpty()) && this.teams != null) {
            List<DriverEntry> derivedDrivers = new ArrayList<>();
            for (var teamEntry : this.teams) {
                if (teamEntry.getRaceDrivers() != null) {
                    derivedDrivers.addAll(teamEntry.getRaceDrivers());
                }
            }
            this.drivers = derivedDrivers;
        }
        return this.drivers;
    }

    public void setDrivers(List<DriverEntry> drivers) {
        this.drivers = drivers;
    }

    public void addDriverEntry(DriverEntry driver) {
        this.drivers.add(driver);
    }

    public void setDriverEntry(int i, DriverEntry driver) {
        this.drivers.set(i-1, driver);
    }

    public List<TeamEntry> getTeams() {
        return this.teams;
    }

    public void setTeams(List<TeamEntry> teams) {
        this.teams = teams;
    }

    public void addTeamEntryList(TeamEntry team) {
        this.teams.add(team);
    }

}
