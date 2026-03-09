package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Repository;
import org.springproj.model.Driver;
import org.springproj.model.DriverEntry;
import org.springproj.repository.DriverDAO;
import org.springproj.repository.DriverEntryDAO;

import java.util.List;

@Repository("driverEntryDao")
public class MemDriverEntryDAO implements DriverEntryDAO {

    public List<DriverEntry> findAll() {
        return SampleData.sampleDriversEntries;
    }

    public DriverEntry findById(int id) {
        return SampleData.sampleDriversEntries.stream().filter((x -> x.getId() == id)).findFirst().get();
    }

    public List<DriverEntry> findByDriver(Driver driver) {
        return SampleData.sampleDriversEntries.stream().filter(x -> x.equals(driver)).toList();
    }

}
