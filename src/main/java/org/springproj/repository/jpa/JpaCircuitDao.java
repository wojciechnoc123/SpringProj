package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springproj.model.Circuit;
import org.springproj.repository.CircuitDAO;

import java.util.List;

@Repository
@Primary
public class JpaCircuitDao implements CircuitDAO {

    private final CircuitJpaRepository circuitRepository;

    public JpaCircuitDao(CircuitJpaRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    @Override
    public List<Circuit> findAll() {
        return this.circuitRepository.findAll();
    }

    @Override
    public Circuit findById(int id) {
        return this.circuitRepository.findById(id).orElse(null);
    }

    @Override
    public Circuit findByName(String name) {
        return this.circuitRepository.findByName(name).orElse(null);
    }
}
