package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springproj.model.Driver;
import org.springproj.repository.DriverDAO;

import java.util.List;

@Repository
@Primary
public class JpaDriverDao implements DriverDAO {

    private final DriverJpaRepository driverRepository;

    public JpaDriverDao(DriverJpaRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> findAll() {
        return this.driverRepository.findAll();
    }

    @Override
    public Driver findByName(String firstName, String lastName) {
        return this.driverRepository.findByFirstnameAndLastName(firstName, lastName).orElse(null);
    }

    @Override
    public Driver findById(int id) {
        return this.driverRepository.findById(id).orElse(null);
    }

    @Override
    public List<Driver> findByCountry(String country) {
        return this.driverRepository.findByCountry(country);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Driver saveDriver(Driver driver) {
        return this.driverRepository.save(driver);
    }
}
