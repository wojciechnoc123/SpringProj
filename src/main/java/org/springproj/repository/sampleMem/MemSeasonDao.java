package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springproj.model.Season;
import org.springproj.repository.SeasonDAO;
import org.springproj.model.Race;

import java.util.List;


@Component
public class MemSeasonDao implements SeasonDAO {

    public Season findByYear(String year) {
        for (var x : SampleData.sampleSeasons) {
            if (x.getYear().equals(year))
                return x;
        }
        return null;
    }

    public Season findByRace(Race race) {
        for (var x : SampleData.sampleSeasons) {
            for (var r : x.getRaces()) {
                if (r.equals(race))
                    return x;
            }
        }
        return null;
    }

    public List<Season> findAll() {
        return SampleData.sampleSeasons;
    }

}
