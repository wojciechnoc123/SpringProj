package org.springproj.repository;

import org.springproj.model.Driver;
import org.springproj.model.Team;
import java.util.List;
public interface DriverDAO {

    List<Driver> findAll();

    Driver findByName(String firstName, String lastName);

    Driver findById(int id);

    List<Driver> findByCountry(String country);

    Driver saveDriver(Driver driver);

}
