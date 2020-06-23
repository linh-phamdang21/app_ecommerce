package com.codegym.repository;

import com.codegym.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBrandRepository extends PagingAndSortingRepository<Brand,Long> {
    Page<Brand> findAllByNameContaining(String name, Pageable pageable);
}
