package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springproj.model.DriverEntry;
import org.springproj.model.TeamEntry;
import org.springproj.repository.TeamEntryDao;
import org.springproj.service.TeamEntryService;


@Service
@Scope("prototype")
public class TeamEntryServiceBean implements TeamEntryService {

    private TeamEntryDao teamEntryDao;

    public TeamEntryServiceBean(TeamEntryDao teamEntryDao) {
        this.teamEntryDao = teamEntryDao;
    }

    public TeamEntry findById(int id) {
        return teamEntryDao.findById(id);
    }

    public TeamEntry findByDriverEntry(DriverEntry driverEntry) {
        return teamEntryDao.findByDriverEntry(driverEntry);
    }

}
