package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springproj.model.GrandPrix;
import org.springproj.model.Season;
import org.springproj.repository.SeasonDAO;

import java.util.List;

@Repository
@Primary
public class JpaSeasonDao implements SeasonDAO {

    private final SeasonJpaRepository seasonRepository;

    public JpaSeasonDao(SeasonJpaRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public Season findByYear(String year) {
        return this.seasonRepository.findByYear(year).orElse(null);
    }

    @Override
    public Season findByRace(GrandPrix grandPrix) {
        if (grandPrix == null) {
            return null;
        }
        return this.seasonRepository.findByGrandPrixes_Id(grandPrix.getId()).orElse(null);
    }

    @Override
    public List<Season> findAll() {
        return this.seasonRepository.findAll();
    }

    @Override
    public Season findById(int id) {
        return this.seasonRepository.findById(id).orElse(null);
    }
}
