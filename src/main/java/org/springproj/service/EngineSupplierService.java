package org.springproj.service;
import org.springproj.model.EngineSupplier;
import java.util.List;

public interface EngineSupplierService {

    List<EngineSupplier> findAll();

    EngineSupplier findById(int id);

    EngineSupplier findByName(String name);

}
