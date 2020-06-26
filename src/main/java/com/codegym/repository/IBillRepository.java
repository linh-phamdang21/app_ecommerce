package com.codegym.repository;

import com.codegym.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByCustomer_IdAndBillStatus_Id(Long customerId, Long statusId);
    List<Bill> findBillByBillStatus_Id(Long id);
}
