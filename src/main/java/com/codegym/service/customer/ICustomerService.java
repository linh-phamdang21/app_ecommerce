package com.codegym.service.customer;

import com.codegym.model.AppCustomer;
import com.codegym.service.generic.IGenericService;

public interface ICustomerService extends IGenericService<AppCustomer> {
    AppCustomer getCustomerByName(String name);
}
