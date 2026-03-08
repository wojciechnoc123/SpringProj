package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.repository.DriverDAO;
import org.springproj.model.Driver;
import org.springproj.model.Team;

import java.util.List;

@Repository("driverDao")
public class MemDriverDao implements DriverDAO {

    @Override
    public List<Driver> findAll() { return SampleData.sampleDrivers; }

    @Override
    public Driver findByName(String fn, String ln) {
        for (var x : SampleData.sampleDrivers)  {
            if (x.getFirstName().equals(fn) && x.getLastName().equals(ln))
                return x;
        }
        return null;
    }


}
