package org.springproj.service;

import org.springproj.model.DriverEntry;
import org.springproj.model.Driver;

import java.util.List;

public interface DriverEntryService {

    DriverEntry findById(int id);

    List<DriverEntry> findByDriver(Driver driver);

    List<DriverEntry> findAll();

}
