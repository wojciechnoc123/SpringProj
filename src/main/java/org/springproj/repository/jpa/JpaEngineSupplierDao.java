package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springproj.model.EngineSupplier;
import org.springproj.repository.EngineSupplierDao;

import java.util.List;

@Repository
@Primary
public class JpaEngineSupplierDao implements EngineSupplierDao {

    private final EngineSupplierJpaRepository engineSupplierRepository;

    public JpaEngineSupplierDao(EngineSupplierJpaRepository engineSupplierRepository) {
        this.engineSupplierRepository = engineSupplierRepository;
    }

    @Override
    public List<EngineSupplier> findAll() {
        return this.engineSupplierRepository.findAll();
    }

    @Override
    public EngineSupplier findById(int id) {
        return this.engineSupplierRepository.findById(id).orElse(null);
    }

    @Override
    public EngineSupplier findByName(String name) {
        return this.engineSupplierRepository.findByName(name).orElse(null);
    }
}
