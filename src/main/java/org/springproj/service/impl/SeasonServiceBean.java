package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springproj.model.GrandPrix;
import org.springproj.model.Season;
import org.springproj.service.SeasonService;
import org.springproj.repository.SeasonDAO;

import java.util.List;


@Service
@Scope("prototype")
public class SeasonServiceBean implements SeasonService {

    private SeasonDAO seasonDao;

    @Override
    public List<Season> findAll() {
        return this.seasonDao.findAll();
    }

    @Override
    public Season findById(int id) {
        return this.seasonDao.findById(id);
    }

    @Override
    public Season findByYear(String year) {
        return this.seasonDao.findByYear(year);
    }

    @Override
    public Season findByRace(GrandPrix gp) {
        return this.seasonDao.findByRace(gp);
    }

}
