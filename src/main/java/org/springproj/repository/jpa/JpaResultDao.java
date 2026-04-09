package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springproj.model.Driver;
import org.springproj.model.Result;
import org.springproj.repository.ResultDAO;

@Repository
@Primary
public class JpaResultDao implements ResultDAO {

    private final ResultJpaRepository resultRepository;

    public JpaResultDao(ResultJpaRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Result findByPosition(int position) {
        return this.resultRepository.findFirstByPosition(position).orElse(null);
    }

    @Override
    public Result findByDriver(Driver driver) {
        if (driver == null) {
            return null;
        }
        return this.resultRepository.findFirstByDriver_Driver_Id(driver.getId()).orElse(null);
    }
}
