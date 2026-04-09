package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.DriverEntry;

import java.util.List;

public interface DriverEntryJpaRepository extends JpaRepository<DriverEntry, Integer> {

    List<DriverEntry> findByDriver_Id(Integer driverId);
}
