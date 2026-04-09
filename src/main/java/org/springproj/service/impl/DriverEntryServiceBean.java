package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springproj.model.Driver;
import org.springproj.model.DriverEntry;
import org.springproj.repository.DriverEntryDAO;
import org.springproj.service.DriverEntryService;

import java.util.List;


@Service
@Scope("prototype")
public class DriverEntryServiceBean implements DriverEntryService {

    private DriverEntryDAO driverEntryDao;


    public DriverEntryServiceBean(DriverEntryDAO driverEntryDAO) {
        this.driverEntryDao = driverEntryDAO;
    }

    @Override
    public DriverEntry findById(int id) {
        return driverEntryDao.findById(id);
    }

    @Override
    public List<DriverEntry> findByDriver(Driver driver) {
        return driverEntryDao.findByDriver(driver);
    }

    @Override
    public List<DriverEntry> findAll() {
        return this.driverEntryDao.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public DriverEntry saveDriverEntry(DriverEntry driverEntry) {
        return this.driverEntryDao.saveDriverEntry(driverEntry);
    }

}
