package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Result {

    private int id;
    private int position;
    private DriverEntry driver;
    private double time;    //in seconds
    private double fastestLap;

    @JsonIgnore
    private GrandPrix grandPrix;

    public Result(int position, DriverEntry driver, double time, double fastestLap, GrandPrix grandPrix) {
        this.position = position;
        this.driver = driver;
        this.time = time;
        this.fastestLap = fastestLap;
        this.grandPrix = grandPrix;
    }

    public Result() {}

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        if (position > 0)
            this.position = position;
    }

    public DriverEntry getDriver() {
        return this.driver;
    }

    public void setDriver(DriverEntry driver) {
        this.driver = driver;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        if (time > 0.0)
            this.time = time;
    }

    public void setFastestLap(double fl) {
        if (fl > 0.0)
            this.fastestLap = fl;
    }

    public double getFastestLap() {
        return this.fastestLap;
    }

    public void setGrandPrix(GrandPrix grandPrix) {
        this.grandPrix = grandPrix;
    }

    public GrandPrix getGrandPrix() {
        return this.grandPrix;
    }

    public String showResult() {
        String result = this.position + ". " + this.driver.getDriver().getFirstName() + " "
                + this.driver.getDriver().getLastName() + " "
                + this.driver.getTeam().getTeam().getName()
                + " " + this.time + " " + this.fastestLap;
        return result;
    }

}
