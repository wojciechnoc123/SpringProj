package org.springproj.repository.sampleMem;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.model.EngineSupplier;
import org.springproj.repository.EngineSupplierDao;

import java.util.List;

@Repository("engineSupplierDao")
public class MemEngineSupplierDao implements EngineSupplierDao {

    @Override
    public List<EngineSupplier> findAll() {
        return SampleData.sampleEngineSuppliers;
    }

}
