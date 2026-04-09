package org.springproj.repository;

import org.springproj.model.DriverEntry;
import org.springproj.model.Driver;

import java.util.List;

public interface DriverEntryDAO {

    List<DriverEntry> findAll();

    DriverEntry findById(int id);

    List<DriverEntry> findByDriver(Driver driver);

    DriverEntry saveDriverEntry(DriverEntry driverEntry);

}
