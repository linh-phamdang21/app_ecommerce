package com.codegym.controller;

import com.codegym.model.Bill;
import com.codegym.model.Cart;
import com.codegym.model.CartProduct;
import com.codegym.model.Product;
import com.codegym.service.cart.ICartService;
import com.codegym.service.product.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private IProduceService produceService;

    @GetMapping("/carts/{id}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart){
        System.out.println(id);
        List<CartProduct> products = cart.getProduct();
        boolean isProductExist = cartService.isExists(id, products);
        if (isProductExist) {
            CartProduct product = cartService.findOne(id, products);
            product.setQuantity(product.getQuantity() + 1);
        } else {
            Optional<Product> product = produceService.getById(id);
            CartProduct cartProduct = new CartProduct(id, product.get().getProductName(), product.get().getImage(), product.get().getPrice(), product.get().getDescribes(), product.get().getCategory(), product.get().getBrand(), 1);
            products.add(cartProduct);
        }
        int totalQuantity = cartService.getTotalQuantity(products);
        cart.setTotalQuantity(totalQuantity);
        float totalPrice = cartService.getTotalPrice(products);
        cart.setTotalPrice(totalPrice);
        System.out.println(totalQuantity);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Cart> removeProduct(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart) {
        List<CartProduct> products = cart.getProduct();
        boolean isProductExist = cartService.isExists(id, products);
        if (isProductExist) {
            cartService.remove(id, products);
            int totalQuantity = cartService.getTotalQuantity(products);
            cart.setTotalQuantity(totalQuantity);
            float totalPrice = cartService.getTotalPrice(products);
            cart.setTotalPrice(totalPrice);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            System.out.println("Unable to delete. Customer with id " + id + "not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}