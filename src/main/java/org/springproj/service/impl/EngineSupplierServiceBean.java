package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springproj.model.EngineSupplier;
import org.springproj.repository.EngineSupplierDao;
import org.springproj.service.EngineSupplierService;

import java.util.List;

@Service
@Scope("prototype")
public class EngineSupplierServiceBean implements EngineSupplierService {

    private final EngineSupplierDao engineSupplierDao;


    public EngineSupplierServiceBean(EngineSupplierDao engineSupplierDao) {
        this.engineSupplierDao = engineSupplierDao;
    }

    @Override
    public List<EngineSupplier> findAll() {
        return this.engineSupplierDao.findAll();
    }

    @Override
    public EngineSupplier findById(int id) {
        return this.engineSupplierDao.findById(id);
    }

    @Override
    public EngineSupplier findByName(String name) {
        return this.engineSupplierDao.findByName(name);
    }

}
