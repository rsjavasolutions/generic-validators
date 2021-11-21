package com.rsjava.validators.car.service;

import com.rsjava.validators.car.CarRepository;
import com.rsjava.validators.car.exception.CarNotFoundException;
import com.rsjava.validators.car.mapper.ICarMapper;
import com.rsjava.validators.car.model.CarEntity;
import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.car.response.CarResponse;
import com.rsjava.validators.common.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService implements ICarService {

    private final ICarMapper carMapper;
    private final CarRepository carRepository;
    private final Validator<CarRequest> newCarValidator;

    @Transactional
    public List<CarResponse> getCars() {

        return carRepository.findAll()
                .stream()
                .map(carMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public CarResponse getCar(String uuid) {
        CarEntity carEntity = carRepository.findByUuid(uuid).orElseThrow(() -> new CarNotFoundException(uuid));
        return carMapper.mapToResponse(carEntity);
    }

    @Transactional
    public String saveCar(CarRequest request) {
        log.debug("Save car request with params: {}", request);
        newCarValidator.validate(request);

        CarEntity carEntity = carMapper.mapToEntity(request);

        return carRepository.save(carEntity).getUuid();
    }

    @Transactional
    public CarResponse updateCar(String uuid, CarRequest request) {
        CarEntity carEntity = carRepository.findByUuid(uuid).orElseThrow(() -> new CarNotFoundException(uuid));

        carEntity.setBrand(request.getBrand());
        carEntity.setModel(request.getModel());

        return carMapper.mapToResponse(carEntity);
    }

    @Transactional
    public void deleteCar(String uuid) {
        carRepository.deleteByUuid(uuid);
    }
}
