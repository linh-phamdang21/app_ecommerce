package com.codegym.service.customer;

import com.codegym.model.AppCustomer;

import com.codegym.service.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenericService<AppCustomer> {
    AppCustomer getCustomerByName(String name);

    Page<AppCustomer> findAllCustomer(Pageable pageable);

    Page<AppCustomer> findAllByUserNameContaining(String name, Pageable pageable);
}
