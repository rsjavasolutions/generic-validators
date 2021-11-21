package com.rsjava.validators.car.validator;

import com.rsjava.validators.car.exception.InvalidCarRequestException;
import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.common.Validator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AudiValidator implements Validator<CarRequest> {

    @Override
    public boolean isValid(CarRequest request) {
        return !(request.getBrand().equals("Audi")
                && request.getYear() < 1909
                || request.getPrice().compareTo(new BigDecimal("25000")) <= 0);
    }

    @Override
    public void validate(CarRequest request) {
        if (!isValid(request)) {
            throw new InvalidCarRequestException("Invalid car request: ", request);
        }
    }
}
