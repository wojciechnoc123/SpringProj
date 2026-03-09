package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springproj.model.Driver;
import org.springproj.repository.DriverDAO;
import org.springproj.service.DriverService;

import java.util.List;


@Service
@Scope("prototype")
public class DriverServiceBean implements DriverService {

    private DriverDAO driverDao;

    public DriverServiceBean(DriverDAO driverDao) {
        this.driverDao = driverDao;
    }


    @Override
    public List<Driver> findAllDrivers() {
        return this.findAllDrivers();
    }

    @Override
    public Driver findById(int id) {
        return this.findById(id);
    }

    @Override
    public Driver findByName(String firstName, String lastName) {
        return this.driverDao.findByName(firstName, lastName);
    }

    @Override
    public List<Driver> findByCountry(String country) {
        return this.driverDao.findByCountry(country);
    }

    @Override
    public Driver saveDriver(Driver driver) {
        return this.driverDao.saveDriver(driver);
    }

}
