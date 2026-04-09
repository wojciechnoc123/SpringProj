package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.GrandPrix;
import org.springproj.model.Season;

import java.util.List;
import java.util.Optional;

public interface GrandPrixJpaRepository extends JpaRepository<GrandPrix, Integer> {

    List<GrandPrix> findBySeason(Season season);

    Optional<GrandPrix> findByName(String name);

    Optional<GrandPrix> findFirstByCountry(String country);
}
