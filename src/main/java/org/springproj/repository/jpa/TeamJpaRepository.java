package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.Team;

import java.util.Optional;

public interface TeamJpaRepository extends JpaRepository<Team, Integer> {

    Optional<Team> findByName(String name);
}
