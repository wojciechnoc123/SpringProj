package org.springproj.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproj.model.Result;

import java.util.Optional;

public interface ResultJpaRepository extends JpaRepository<Result, Integer> {

    Optional<Result> findFirstByPosition(Integer position);

    Optional<Result> findFirstByDriver_Driver_Id(Integer driverId);
}
