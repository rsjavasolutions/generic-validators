package com.rsjava.validators.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ValidatorFactory {

    private final BeanFactory beanFactory;

    @SafeVarargs
    public final <V> Validator<V> create(Class<? extends Validator<? extends V>>... validatorClasses) {
        return new ComplexValidator(
                Stream.of(validatorClasses)
                        .map(beanFactory::getBean)
                        .collect(Collectors.toList())
        );
    }
}
