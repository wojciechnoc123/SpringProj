package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springproj.model.DriverEntry;
import org.springproj.repository.DriverEntryDao;

import java.util.List;

@Component
public class MemDriverEntryDao implements DriverEntryDao {

    public List<DriverEntry> findAll() {
        return SampleData.sampleDriversEntries;
    }

}
