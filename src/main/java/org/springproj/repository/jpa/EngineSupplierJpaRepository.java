package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.EngineSupplier;

import java.util.Optional;

public interface EngineSupplierJpaRepository extends JpaRepository<EngineSupplier, Integer> {

    Optional<EngineSupplier> findByName(String name);
}
