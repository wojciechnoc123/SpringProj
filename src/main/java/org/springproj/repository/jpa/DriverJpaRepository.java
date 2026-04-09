package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverJpaRepository extends JpaRepository<Driver, Integer> {

    Optional<Driver> findByFirstnameAndLastName(String firstname, String lastName);

    List<Driver> findByCountry(String country);
}
