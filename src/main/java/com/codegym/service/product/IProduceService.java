package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.service.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProduceService extends IGenericService<Product> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByProductNameContaining(String productName,Pageable pageable);
}
