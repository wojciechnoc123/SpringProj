package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;


public class Driver {

    private int id;
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;
    private String lastName;
    private int age;
    private String country;



    public Driver(int id, String firstName, String lastName, int age, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public Driver(String firstName, String lastName, int age, String country) {
        this(0,firstName,lastName,age,country);
    }

    public Driver() {

    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
