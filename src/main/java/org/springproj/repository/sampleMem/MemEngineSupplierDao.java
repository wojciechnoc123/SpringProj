package org.springproj.repository.sampleMem;


import org.springframework.stereotype.Component;
import org.springproj.model.EngineSupplier;
import org.springproj.repository.EngineSupplierDao;

import java.util.List;

@Component
public class MemEngineSupplierDao implements EngineSupplierDao {

    @Override
    public List<EngineSupplier> findAll() {
        return SampleData.sampleEngineSuppliers;
    }

}
