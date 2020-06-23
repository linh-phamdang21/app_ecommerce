package com.codegym.repository;

import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface ITypeReposity extends PagingAndSortingRepository<ProductType, Long> {
    Page<ProductType> findAllByNameContaining(String name, Pageable pageble);
}
