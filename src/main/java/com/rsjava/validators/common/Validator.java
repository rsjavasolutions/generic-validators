package com.rsjava.validators.common;

public interface Validator<T> {

    boolean isValid(T value);

    default void validate(T value){}
}
