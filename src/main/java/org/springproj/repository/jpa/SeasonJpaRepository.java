package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.Season;

import java.util.Optional;

public interface SeasonJpaRepository extends JpaRepository<Season, Integer> {

    Optional<Season> findByYear(String year);

    Optional<Season> findByGrandPrixes_Id(Integer grandPrixId);
}
