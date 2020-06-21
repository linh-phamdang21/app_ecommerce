package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @GetMapping("/admin")
    public ModelAndView orderPage(){
        ModelAndView modelAndView = new ModelAndView("order");
        return modelAndView;
    }

}