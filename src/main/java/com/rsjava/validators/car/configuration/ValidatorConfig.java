package com.rsjava.validators.car.configuration;

import com.rsjava.validators.car.request.CarRequest;
import com.rsjava.validators.common.ComplexValidator;
import com.rsjava.validators.common.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration("CarValidatorConfig")
public class ValidatorConfig {

    @Bean
    @Primary
    public ComplexValidator<CarRequest> carValidator(List<Validator<CarRequest>> validators) {
        return new ComplexValidator<>(
                validators
        );
    }
}
