package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springproj.model.Driver;
import org.springproj.model.DriverEntry;
import org.springproj.repository.DriverEntryDAO;

import java.util.List;

@Repository
@Primary
public class JpaDriverEntryDao implements DriverEntryDAO {

    private final DriverEntryJpaRepository driverEntryRepository;

    public JpaDriverEntryDao(DriverEntryJpaRepository driverEntryRepository) {
        this.driverEntryRepository = driverEntryRepository;
    }

    @Override
    public List<DriverEntry> findAll() {
        return this.driverEntryRepository.findAll();
    }

    @Override
    public DriverEntry findById(int id) {
        return this.driverEntryRepository.findById(id).orElse(null);
    }

    @Override
    public List<DriverEntry> findByDriver(Driver driver) {
        if (driver == null) {
            return List.of();
        }
        return this.driverEntryRepository.findByDriver_Id(driver.getId());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public DriverEntry saveDriverEntry(DriverEntry driverEntry) {
        return this.driverEntryRepository.save(driverEntry);
    }
}
