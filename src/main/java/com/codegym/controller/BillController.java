package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BillController {
    @GetMapping("/bill")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("bill");
        return modelAndView;
    }
}
