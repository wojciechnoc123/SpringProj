package org.springproj.service;

import java.util.List;
import org.springproj.model.Driver;

public interface DriverService {

    List<Driver> findAllDrivers();

    Driver findById(int id);

    Driver findByName(String firstName, String lastName);

    List<Driver> findByCountry(String country);

    Driver saveDriver(Driver driver);

}
