package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GrandPrix {

    private int id;
    private String name;
    private String country;
    private String date; //DD-MM rok zaciagany z seonu
    private Circuit circuit;

    @JsonIgnore
    private Season season;

    private List<Result> results;

    public GrandPrix(int id, String name, Circuit circuit, String country, String date, Season season, List<Result> results) {
        this.id = id;
        this.name = name;
        this.circuit = circuit;
        this.country = country;
        this.date = date;
        this.season = season;
        this.results = results;
    }

    public GrandPrix(int id, String name, Circuit circuit, String country, String date, Season season) {
        this(id, name, circuit, country, date, season, new ArrayList<>());
    }


    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public Circuit getCircuit() {
        return this.circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
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
        String text = "Position Driver Team Time Fastest-lap";
        finalResult.append(text);
        for (var x : this.results) {
            finalResult.append(x.showResult());
            finalResult.append("\n");
        }
        return String.valueOf(finalResult);
    }
}
