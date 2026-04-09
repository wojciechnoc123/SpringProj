package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.Engine;

public interface EngineJpaRepository extends JpaRepository<Engine, Integer> {
}
