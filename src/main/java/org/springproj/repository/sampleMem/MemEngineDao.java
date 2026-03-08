package org.springproj.repository.sampleMem;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.model.Engine;
import org.springproj.repository.EngineDao;

import java.util.List;

@Repository("engineDao")
public class MemEngineDao implements EngineDao {

    @Override
    public List<Engine> findAll() {
        return SampleData.sampleEngines;
    }

}
