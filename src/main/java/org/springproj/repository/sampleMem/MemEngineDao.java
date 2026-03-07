package org.springproj.repository.sampleMem;


import org.springframework.stereotype.Component;
import org.springproj.model.Engine;
import org.springproj.repository.EngineDao;

import java.util.List;

@Component
public class MemEngineDao implements EngineDao {

    @Override
    public List<Engine> findAll() {
        return SampleData.sampleEngines;
    }

}
