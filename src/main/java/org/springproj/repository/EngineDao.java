package org.springproj.repository;

import org.springproj.model.Engine;
import java.util.List;

public interface EngineDao {

    List<Engine> findAll();


}
