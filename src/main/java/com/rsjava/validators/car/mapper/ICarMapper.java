package com.rsjava.validators.car.mapper;

import com.rsjava.validators.car.model.CarEntity;
import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.car.response.CarResponse;


public interface ICarMapper {

    CarEntity mapToEntity(CarRequest request);

    CarResponse mapToResponse(CarEntity entity);
}
