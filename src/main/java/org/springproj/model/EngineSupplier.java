package org.springproj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "engine_supplier")
public class EngineSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "city_location")
    private String cityLocation;
    private String country;

    //dodac spis wszystkich silnikow?

    public EngineSupplier(int id, String name, String cityLocation, String country) {
        this.id = id;
        this.name = name;
        this.cityLocation = cityLocation;
        this.country = country;
    }

    public EngineSupplier() {}

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
