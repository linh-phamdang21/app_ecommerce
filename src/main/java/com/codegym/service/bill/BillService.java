package com.codegym.service.bill;

import com.codegym.model.Bill;
import com.codegym.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BillService implements IBillService {

    @Autowired
    private IBillRepository billRepository;

    @Override
    public Iterable<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Optional<Bill> getById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill save(Bill model) {
        billRepository.save(model);
        return model;
    }

    @Override
    public void remove(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> getAllBillByCustomerIdAndStatus(Long customerId, Long statusId) {
        return billRepository.findByCustomer_IdAndBillStatus_Id(customerId, statusId);
    }
}