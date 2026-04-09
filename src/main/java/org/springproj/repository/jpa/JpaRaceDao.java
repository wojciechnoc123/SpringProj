package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springproj.model.GrandPrix;
import org.springproj.model.Season;
import org.springproj.repository.RaceDAO;

import java.util.List;

@Repository
@Primary
public class JpaRaceDao implements RaceDAO {

    private final GrandPrixJpaRepository grandPrixRepository;

    public JpaRaceDao(GrandPrixJpaRepository grandPrixRepository) {
        this.grandPrixRepository = grandPrixRepository;
    }

    @Override
    public List<GrandPrix> findAll() {
        return this.grandPrixRepository.findAll();
    }

    @Override
    public List<GrandPrix> findBySeason(Season season) {
        return this.grandPrixRepository.findBySeason(season);
    }

    @Override
    public GrandPrix findByName(String name) {
        return this.grandPrixRepository.findByName(name).orElse(null);
    }

    @Override
    public GrandPrix findByCountry(String country) {
        return this.grandPrixRepository.findFirstByCountry(country).orElse(null);
    }
}
