package com.codegym.service.price;

import com.codegym.model.Price;
import org.springframework.stereotype.Service;

@Service
public interface IPriceService {
    Iterable<Price> findAll();
}
