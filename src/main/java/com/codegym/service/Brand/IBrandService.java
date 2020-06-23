package com.codegym.service.Brand;

import com.codegym.model.Brand;
import com.codegym.service.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandService  extends IGenericService<Brand> {
    Page<Brand> findAll(Pageable pageable);
    Page<Brand> findAllByNameContaining(String name,Pageable pageable);
}
