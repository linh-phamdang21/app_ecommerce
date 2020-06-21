package com.codegym.repository;

import com.codegym.model.AppCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<AppCustomer, Long> {
    AppCustomer findByUsername(String username);
}
