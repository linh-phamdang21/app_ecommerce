package com.codegym.service.billStatus;

import com.codegym.model.BillStatus;
import com.codegym.repository.IBillStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillStatusService implements IBillStatusService {

    @Autowired
    private IBillStatusRepository billStatusRepository;

    @Override
    public Iterable<BillStatus> findAll() {
        return billStatusRepository.findAll();
    }

    @Override
    public Optional<BillStatus> getById(Long id) {
        return billStatusRepository.findById(id);
    }

    @Override
    public BillStatus save(BillStatus model) {
        return billStatusRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        billStatusRepository.deleteById(id);
    }
}