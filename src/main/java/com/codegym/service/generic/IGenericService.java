package com.codegym.service.generic;

import java.util.Optional;

public interface IGenericService<T> {

    Iterable<T> findAll();
    Optional<T> getById(Long id);
    T save (T model);
    void remove(Long id);
}
