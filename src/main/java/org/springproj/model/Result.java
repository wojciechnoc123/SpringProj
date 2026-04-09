package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int position;
    @ManyToOne
    @JoinColumn(name = "driver_entry_id")
    private DriverEntry driver;
    @Column(name = "race_time")
    private double raceTime;    //in seconds
    @Column(name = "fastest_lap")
    private double fastestLap;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "grand_prix_id")
    private GrandPrix grandPrix;

    public Result(int position, DriverEntry driver, double raceTime, double fastestLap, GrandPrix grandPrix) {
        this.position = position;
        this.driver = driver;
        this.raceTime = raceTime;
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

    public double getRaceTime() {
        return this.raceTime;
    }

    public void setRaceTime(double raceTime) {
        if (raceTime > 0.0)
            this.raceTime = raceTime;
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
        String result = this.position + ". " + this.driver.getDriver().getFirstname() + " "
                + this.driver.getDriver().getLastname() + " "
                + this.driver.getTeam().getTeam().getName()
                + " " + this.raceTime + " " + this.fastestLap;
        return result;
    }

}
