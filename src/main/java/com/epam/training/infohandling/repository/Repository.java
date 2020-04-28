package com.epam.training.infohandling.repository;

import com.epam.training.infohandling.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T object);

    void remove(T object);

    void update(T object);

    List<T> getAll();

    List<TextComponent> sort(Comparator<T> comparator);

    List<T> query(Specification<T> specification);
}
