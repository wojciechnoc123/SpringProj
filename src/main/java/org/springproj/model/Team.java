package org.springproj.model;
import jakarta.validation.constraints.*;
public class Team {

    private int id;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    private String cityLocation;
    private String country;

    //dodac spis wszystkich startow zespolow?


    public Team(int id, String name, String cityLocation, String country) {
        this.id = id;
        this.name = name;
        this.cityLocation = cityLocation;
        this.country = country;
    }

    public Team(String name, String cityLocation, String country) {
        this(0,name, cityLocation, country);
    }

    public Team() {

    }


    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityLocation() {
        return this.cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }





}
