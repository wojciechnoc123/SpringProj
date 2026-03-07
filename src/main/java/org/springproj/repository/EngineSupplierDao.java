package org.springproj.repository;

import java.util.List;
import org.springproj.model.EngineSupplier;

public interface EngineSupplierDao {

    List<EngineSupplier> findAll();

}
