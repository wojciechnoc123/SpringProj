package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
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
        return this.driverDao.findAll();
    }

    @Override
    public Driver findById(int id) {
        return this.driverDao.findById(id);
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
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Driver saveDriver(Driver driver) {
        Driver savedDriver = this.driverDao.saveDriver(driver);
        boolean rollbackRequested =
                (savedDriver.getFirstname() != null && savedDriver.getFirstname().toLowerCase().contains("rollback"))
                || (savedDriver.getLastname() != null && savedDriver.getLastname().toLowerCase().contains("rollback"));
        if (rollbackRequested) {
            throw new RuntimeException("transaction rollback test for driver save");
        }
        return savedDriver;
    }

}
