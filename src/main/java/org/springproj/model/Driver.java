package org.springproj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import org.springproj.model.converts.MyConverts;

import java.time.LocalDate;


public class Driver {

    private int id;
    @NotNull
    @Size(min = 2, max = 20)
    private String firstname;
    private String lastName;
    private String country;
    //for now accepted format is YYYY-MM-DD from string as example
    //1999-10-3
    private LocalDate birthDate;

    public Driver(int id, String firstName, String lastName, String country, LocalDate birthDate) {
        this.id = id;
        this.firstname = firstName;
        this.lastName = lastName;
        this.country = country;
        this.birthDate = birthDate;
    }

    public Driver(int id, String firstName, String lastName, String country) {
        this (id, firstName, lastName, country, LocalDate.now());
    }

    public Driver(String firstName, String lastName, String country) {
        this(0, firstName, lastName, country);
    }

    public Driver() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String fn) {
        this.firstname = fn;
    }

    public String getLastname() {
        return this.lastName;
    }

    public void setLastname(String ln) {
        this.lastName = ln;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - this.birthDate.getYear();
        if (today.getMonthValue() < this.birthDate.getMonthValue() && today.getDayOfMonth() < this.birthDate.getDayOfMonth())
            return (age - 1);
        else
            return age;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = MyConverts.convertFromDate(birthDate);
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
