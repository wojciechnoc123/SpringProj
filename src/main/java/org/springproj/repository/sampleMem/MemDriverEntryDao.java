package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.model.DriverEntry;
import org.springproj.repository.DriverEntryDao;

import java.util.List;

@Repository("driverEntryDao")
public class MemDriverEntryDao implements DriverEntryDao {

    public List<DriverEntry> findAll() {
        return SampleData.sampleDriversEntries;
    }

}
