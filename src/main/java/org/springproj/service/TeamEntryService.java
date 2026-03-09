package org.springproj.service;

import org.springproj.model.DriverEntry;
import org.springproj.model.TeamEntry;

public interface TeamEntryService {

    TeamEntry findById(int id);

    TeamEntry findByDriverEntry(DriverEntry driverEntry);

}
