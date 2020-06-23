package com.codegym.service.type;

import com.codegym.model.ProductType;
import com.codegym.service.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IProductTypeService extends IGenericService {
    Page<ProductType> findAll(Pageable pageable);
    Page<ProductType> findAllByNameContaining(String name, Pageable pageable);
    Iterable<ProductType> findAll();
}

