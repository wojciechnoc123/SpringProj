package org.springproj.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


public class Season {

    private String year;

    @JsonIgnore
    private List<Race> races;

    public Season(String year, List<Race> races) {
        this.year = year;
        this.races = races;
    }
    public Season(String year) {
        this(year,new ArrayList<>());
    }

    public String getYear() {
        return this.year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public List<Race> getRaces() {
        return this.races;
    }

    public Race getRace(int i) {
        if (i < this.races.size())
            return this.races.get(i);
        else
            return this.races.get(this.races.size() - 1);
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public void addRace(Race race) {
        this.races.add(race);
    }

    public void setRace(int i, Race race) {
        this.races.set(i-1, race);
    }
}
