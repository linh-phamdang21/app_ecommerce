package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/carts")
    public ModelAndView cartPage(){
        ModelAndView modelAndView = new ModelAndView("cart");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView productPage(){
        ModelAndView modelAndView = new ModelAndView("product");
        return modelAndView;
    }

    @GetMapping("/product-detail")
    public ModelAndView productDetailsPage(){
        ModelAndView modelAndView = new ModelAndView("product-detail");
        return modelAndView;
    }

}
