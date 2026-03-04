package org.springproj.model;

public class Result {

    private int position;
    private Driver driver;
    private double time;    //in seconds
    private double fastestLap;
    private Race race;

    public Result(int position, Driver driver, double time, double fastestLap, Race race) {
        this.position = position;
        this.driver = driver;
        this.time = time;
        this.fastestLap = fastestLap;
        this.race = race;
    }

    public Result() {

    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        if (position > 0)
            this.position = position;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setDriver(Driver driver) {
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

    public void setRace(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return this.race;
    }

    public String showResult() {
        return this.position + " "  + driver.getFirstName() + " " + driver.getLastName() + " "
                + driver.getCurrentTeam().getName()
                + " time: "
                + this.time + " fastest lap: " + this.fastestLap;
    }

}
