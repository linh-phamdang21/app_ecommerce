package com.codegym.service.cart;

import com.codegym.model.CartProduct;
import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService implements ICartService {
    @Override
    public int getTotalQuantity(List<CartProduct> products) {
        int totalQuantity = 0;
        for (CartProduct product : products) {
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;
    }

    @Override
    public float getTotalPrice(List<CartProduct> products) {
        float totalPrice = 0;
        for (CartProduct product : products) {
            totalPrice += product.getQuantity() * product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public boolean isExists(Long id, List<CartProduct> products) {
        for (CartProduct product : products) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CartProduct findOne(Long id, List<CartProduct> products) {
        for (CartProduct product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Long id, List<CartProduct> products) {
        CartProduct product = findOne(id, products);
        if (product != null) {
            products.remove(product);
            return true;
        } else {
            return false;
        }
    }
}