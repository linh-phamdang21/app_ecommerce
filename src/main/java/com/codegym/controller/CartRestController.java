package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.CartProduct;
import com.codegym.model.Product;
import com.codegym.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@RestController
@RequestMapping("/api")
@SessionAttributes("cart")
public class CartRestController {

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @Autowired
    private ICartService cartService;

    @PostMapping("/carts")
    public ResponseEntity<String> addToCart(@RequestBody Product product, @ModelAttribute("cart") Cart cart){
        List<CartProduct> products = cart.getProduct();
        boolean isProductExist = cartService.isExists(product.getId(), products);
        if (isProductExist) {
            CartProduct product1 = cartService.findOne(product.getId(), products);
            product1.setQuantity(product1.getQuantity() + 1);
        } else {
            CartProduct product1 = new CartProduct(product.getId(), product.getProductName(), product.getImage(), product.getPrice(), product.getDescribes(), product.getCategory(), product.getBrand(), 1);
            products.add(product1);
            System.out.println("id : " + products.get(0).getId());
        }
        int totalQuantity = cartService.getTotalQuantity(products);
        cart.setTotalQuantity(totalQuantity);
        float totalPrice = cartService.getTotalPrice(products);
        cart.setTotalPrice(totalPrice);
        System.out.println(totalQuantity);
        return new ResponseEntity<>(String.valueOf(totalQuantity), HttpStatus.OK);
    }
//
//    @DeleteMapping("/carts/{id}")
//    public ResponseEntity<Bill> removeProduct(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart) {
//        List<Product> products = cart.getProducts();
//        boolean isProductExist = cartService.isExists(id, products);
//        if (isProductExist) {
//            cartService.remove(id, products);
//            int totalQuantity = cartService.getTotalQuantity(products);
//            cart.setTotalQuantity(totalQuantity);
//            float totalPrice = cartService.getTotalPrice(products);
//            cart.setTotalPrice(totalPrice);
//            Bill bill = new Bill(totalQuantity, totalPrice);
//            return new ResponseEntity<>(bill, HttpStatus.OK);
//        } else {
//            System.out.println("Unable to delete. Customer with id " + id + "not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}