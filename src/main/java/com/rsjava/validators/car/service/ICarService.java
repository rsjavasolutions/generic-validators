package com.rsjava.validators.car.service;

import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.car.response.CarResponse;

import java.util.List;

public interface ICarService {

    List<CarResponse> getCars();

    CarResponse getCar(String uuid);

    String saveCar(CarRequest request);

    CarResponse updateCar(String uuid, CarRequest request);

    void deleteCar(String uuid);
}
