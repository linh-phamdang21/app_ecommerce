package com.codegym.service.bill;

import com.codegym.model.Bill;
import com.codegym.service.generic.IGenericService;

import java.util.List;

public interface IBillService extends IGenericService<Bill> {
    List<Bill> getAllBillByCustomerIdAndStatus(Long customerId, Long statusId);
    List<Bill> findBillByBillStatus_Id(Long id);
}
