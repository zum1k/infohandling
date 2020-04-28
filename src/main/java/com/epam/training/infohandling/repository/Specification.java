package com.epam.training.infohandling.repository;

public interface Specification<T> {
    boolean isSpecified(T object);
}
