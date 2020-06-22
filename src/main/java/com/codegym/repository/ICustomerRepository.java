package com.codegym.repository;

import com.codegym.model.AppCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<AppCustomer, Long> {
    AppCustomer findByUsername(String username);
}
