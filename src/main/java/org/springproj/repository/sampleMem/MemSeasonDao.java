package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.model.Season;
import org.springproj.repository.SeasonDAO;
import org.springproj.model.GrandPrix;

import java.util.List;


@Repository("seasonDao")
public class MemSeasonDao implements SeasonDAO {

    public Season findByYear(String year) {
        for (var x : SampleData.sampleSeasons) {
            if (x.getYear().equals(year))
                return x;
        }
        return null;
    }

    public Season findByRace(GrandPrix grandPrix) {
        for (var x : SampleData.sampleSeasons) {
            for (var r : x.getGrandPrixes()) {
                if (r.equals(grandPrix))
                    return x;
            }
        }
        return null;
    }

    public List<Season> findAll() {
        return SampleData.sampleSeasons;
    }

    public Season findById(int i) {
        for (var x : SampleData.sampleSeasons) {
            if (x.getId() == i)
                return x;
        }
        return null;
    }

}
