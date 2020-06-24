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

@Controller
@SessionAttributes({"cart", "customer"})
public class CartController {

    @ModelAttribute("customer")
    public AppCustomer setUpCustomer(){
        return new AppCustomer();
    }

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/cart-buy")
    public ModelAndView billPage(@ModelAttribute AppCustomer customer) {
        if (customer.getId() == null){
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("bill");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
    }

}