package com.codegym.repository;

import com.codegym.model.AppCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppCustomer,Long> {

}
