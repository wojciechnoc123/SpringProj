package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.Circuit;

import java.util.Optional;

public interface CircuitJpaRepository extends JpaRepository<Circuit, Integer> {

    Optional<Circuit> findByName(String name);
}
