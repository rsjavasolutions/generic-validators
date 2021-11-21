package com.rsjava.validators.car.validator;

import com.rsjava.validators.car.exception.InvalidCarRequestException;
import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.common.Validator;
import org.springframework.stereotype.Component;

@Component
public class FordValidator implements Validator<CarRequest> {

    @Override
    public boolean isValid(CarRequest request) {
        return !(request.getBrand().equals("Ford") && request.getYear() < 1903);
    }

    @Override
    public void validate(CarRequest request) {
        if (!isValid(request)) {
            throw new InvalidCarRequestException("Invalid car request: ", request);
        }
    }
}
