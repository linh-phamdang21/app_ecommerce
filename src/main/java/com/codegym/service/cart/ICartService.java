package com.codegym.service.cart;

import com.codegym.model.CartProduct;
import com.codegym.model.Product;

import java.util.List;

public interface ICartService {

    int getTotalQuantity(List<CartProduct> products);

    float getTotalPrice(List<CartProduct> products);

    boolean isExists(Long id, List<CartProduct> products);

    CartProduct findOne(Long id, List<CartProduct> products);

    boolean remove(Long id, List<CartProduct> products);
}
