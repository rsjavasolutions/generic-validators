package com.rsjava.validators.car.mapper;

import com.rsjava.validators.car.model.CarEntity;
import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.car.response.CarResponse;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements ICarMapper {

    public CarEntity mapToEntity(CarRequest request) {
        return new CarEntity(
                request.getBrand(),
                request.getModel(),
                request.getYear(),
                request.getPrice()
        );
    }

    public CarResponse mapToResponse(CarEntity entity) {
        return new CarResponse(
                entity.getUuid(),
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getYear(),
                entity.getPrice(),
                entity.getCreationDateTime());
    }
}
