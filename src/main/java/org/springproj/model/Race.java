package org.springproj.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {

    private String name;
    private String cityLocation;
    private String country;
    private String date; //DD-MM rok zaciagany z seonu

    private Season season;

    private List<Result> results;

    public Race(String name, String cityLocation, String country, String date, Season season, List<Result> results) {
        this.name = name;
        this.cityLocation = cityLocation;
        this.country = country;
        this.date = date;
        this.season = season;
        this.results = results;
    }
    public Race(String name, String cityLocation, String country, String date, Season season) {
        this(name, cityLocation, country, date, season, new ArrayList<>());
    }

    public Race() {
        this("", "", "", "DD-MM",null,null);
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public Season getSeason() {
        return this.season;
    }
    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Result> getResults() {
        return this.results;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
    public void addResult(Result result) {
        this.results.add(result);
    }

    public void sortResults() {
        this.results.sort(Comparator.comparingInt(r -> r.getPosition()));
    }

    public String showResults() {
        StringBuilder finalResult = new StringBuilder();
        for (var x : this.results) {
            finalResult.append(x.showResult());
            finalResult.append("\n");
        }
        return String.valueOf(finalResult);
    }
}
