package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springproj.model.Engine;
import org.springproj.repository.EngineDao;

import java.util.List;

@Repository
@Primary
public class JpaEngineDao implements EngineDao {

    private final EngineJpaRepository engineRepository;

    public JpaEngineDao(EngineJpaRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public List<Engine> findAll() {
        return this.engineRepository.findAll();
    }
}
