package com.codegym.service.billDetail;

import com.codegym.model.BillDetail;
import com.codegym.repository.IBillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BillDetailService implements IBillDetailService {

    @Autowired
    private IBillDetailRepository billDetailRepository;

    @Override
    public Iterable<BillDetail> findAll() {
        return billDetailRepository.findAll();
    }

    @Override
    public Optional<BillDetail> getById(Long id) {
        return billDetailRepository.findById(id);
    }

    @Override
    public BillDetail save(BillDetail model) {
        billDetailRepository.save(model);
        return model;
    }

    @Override
    public void remove(Long id) {
        billDetailRepository.deleteById(id);
    }
}