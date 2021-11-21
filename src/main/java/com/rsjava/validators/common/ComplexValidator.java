package com.rsjava.validators.common;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ComplexValidator<T> implements Validator<T> {

    private final List<Validator<T>> validators;

    @Override
    public boolean isValid(T value) {
        return validators.stream()
                .allMatch(tValidator -> tValidator.isValid(value));
    }

    @Override
    public void validate(T value){
        validators.forEach(tValidator -> tValidator.validate(value));
    }
}
