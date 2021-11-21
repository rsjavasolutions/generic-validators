package com.rsjava.validators.car;

import com.rsjava.validators.car.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    Optional<CarEntity> findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
