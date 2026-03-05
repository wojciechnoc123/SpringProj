package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Driver {

    private String firstName;
    private String lastName;
    private int age;

    private int number;

    @JsonIgnore
    private Team currentTeam;

    public Driver(String fn, String ln, int age, int number, Team team) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = age;
        this.number = number;
        this.currentTeam = team;
    }

    public Driver(String fn, String ln, int age, int number) {
        this(fn, ln, age, number, null);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        }
    }

    public int getNumber() {
        return this.number;
    }

    public Team getCurrentTeam() {
        return this.currentTeam;
    }

    public void setCurrentTeam(Team team) {
        this.currentTeam = team;
    }

}
