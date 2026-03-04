package org.springproj.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private String cityLocation;
    private String country;

    private List<Driver> drivers;

    private final Driver[] gridDrivers = new Driver[2];

    public Team(String name, String cityLocation, String country, List<Driver> drivers) {
        this.name = name;
        this.cityLocation = cityLocation;
        this.country = country;
        this.drivers = drivers;
    }

    public Team(String name, String cityLocation, String country) {
        this(name, cityLocation, country, new ArrayList<>());
    }

    public Team() {
        this("", "", "", null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.cityLocation;
    }

    public void setCity(String city) {
        this.cityLocation = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Driver> getDrivers() {
        return this.drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
    }

    public void setGridDrivers(Driver driver1, Driver driver2) {
        this.gridDrivers[0] = driver1;
        this.gridDrivers[1] = driver2;
    }

    public Driver[] getGridDrivers() {
        return this.gridDrivers;
    }

    public Driver getFristDriver() {
        return this.gridDrivers[0];
    }

    public void setFirstDriver(Driver firstDriver) {
        this.gridDrivers[0] = firstDriver;
    }

    public Driver getSecondDriver() {
        return this.gridDrivers[1];
    }

    public void setSecondDriver(Driver secondDriver) {
        this.gridDrivers[1] = secondDriver;
    }



}
