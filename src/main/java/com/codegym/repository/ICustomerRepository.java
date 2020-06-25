package com.codegym.repository;

import com.codegym.model.AppCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface ICustomerRepository extends PagingAndSortingRepository<AppCustomer, Long> {
    AppCustomer findByUsername(String username);
    Page<AppCustomer> findAllByUsernameContaining(String name , Pageable pageable);
}
