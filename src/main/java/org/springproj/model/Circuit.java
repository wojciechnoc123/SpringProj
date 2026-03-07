package org.springproj.model;

public class Circuit {

    private int id;
    private String name;
    private String country;
    private String location;

    public Circuit(int id, String name, String country, String location) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.location = location;
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
