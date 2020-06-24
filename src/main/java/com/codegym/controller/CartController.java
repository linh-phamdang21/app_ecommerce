package com.codegym.controller;

import com.codegym.model.AppCustomer;
import com.codegym.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@SessionAttributes({"cart", "sessionCustomer"})
public class CartController {

    @ModelAttribute("sessionCustomer")
    public AppCustomer setUpCustomer(){
        return new AppCustomer();
    }

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/cart-buy")
    public ModelAndView billPage(@ModelAttribute("sessionCustomer") AppCustomer customer) {

        if (customer.getId() == null){
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("bill");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
    }
    @PostMapping("/cart-buy")
    public ModelAndView buyProduct(@ModelAttribute("sessionCustomer") AppCustomer customer, @ModelAttribute("cart") Cart cart) {
       ModelAndView modelAndView = new ModelAndView("bill");
        System.out.println(customer.getId());
        System.out.println(cart.getTotalPrice());
        System.out.println("-------------------------");
        System.out.println(java.time.LocalDate.now());
        System.out.println("-------------------------");
        Long ti = System.currentTimeMillis();

        Timestamp timestamp = new Timestamp(ti);
        System.out.println("time tamp : "+ timestamp);
        return modelAndView;

    }
}