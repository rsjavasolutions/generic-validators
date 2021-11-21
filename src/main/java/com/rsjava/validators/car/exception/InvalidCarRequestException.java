package com.rsjava.validators.car.exception;

import com.rsjava.validators.car.request.CarRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCarRequestException extends RuntimeException {

    public InvalidCarRequestException(String message, CarRequest request) {
        super(String.format(message, request));
        log.debug(message, request);
    }
}
