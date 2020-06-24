package com.codegym.service.price;

import com.codegym.model.Price;
import com.codegym.repository.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PriceSersiveImpl implements IPriceService{

    @Autowired
    private IPriceRepository priceRepository;

    @Override
    public Iterable<Price> findAll() {
        return priceRepository.findAll();
    }
}
