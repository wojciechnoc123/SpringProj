package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springproj.repository.CircuitDAO;
import org.springproj.service.CircuitService;
import org.springproj.model.Circuit;
import java.util.List;

@Service
@Scope("prototype")

public class CircuitServiceBean implements CircuitService {

    private CircuitDAO circuitDao;

    public CircuitServiceBean(CircuitDAO circuitDao) {
        this.circuitDao = circuitDao;
    }

    @Override
    public List<Circuit> findAll() {
        return this.circuitDao.findAll();
    }

    @Override
    public Circuit findById(int id) {
        return this.circuitDao.findById(id);
    }

    @Override
    public Circuit findByName(String name) {
        return this.circuitDao.findByName(name);
    }

}
