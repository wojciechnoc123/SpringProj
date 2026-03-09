package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.repository.DriverDAO;
import org.springproj.model.Driver;
import org.springproj.model.Team;

import java.util.Collections;
import java.util.Comparator;
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

    @Override
    public Driver findById(int id) {
        //    do zadania potrzebuje nulla a tu jest optional co albo zwraca obiekt albo NPE
        //    return SampleData.sampleDrivers.stream().filter(x -> x.getId() == id).findFirst().get();
        for (var x : SampleData.sampleDrivers) {
            if (x.getId() == id)
                return x;
        }
        return null;
    }

    @Override
    public List<Driver> findByCountry(String country) {
        return SampleData.sampleDrivers.stream().filter(x -> x.getCountry().equals(country)).toList();
    }

    @Override
    public Driver saveDriver(Driver driver) {
        SampleData.sampleDrivers.sort(Comparator.comparingInt(Driver::getId));
        int idToAdd = SampleData.sampleDrivers.get(SampleData.sampleDrivers.size() - 1).getId();
        driver.setId(idToAdd+1);
        SampleData.sampleDrivers.add(driver);
        return driver;
    }



}
