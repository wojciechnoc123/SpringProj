package org.springproj.model;

public class EngineSupplier {

    private int id;
    private String name;
    private String cityLocation;
    private String country;

    //dodac spis wszystkich silnikow?

    public EngineSupplier(int id, String name, String cityLocation, String country) {
        this.id = id;
        this.name = name;
        this.cityLocation = cityLocation;
        this.country = country;
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
