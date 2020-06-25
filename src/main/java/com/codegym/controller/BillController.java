package com.codegym.controller;

import com.codegym.model.Bill;
import com.codegym.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BillController {

    @Autowired
    private IBillService billService;

    @GetMapping("/bills")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("bill/list");
        modelAndView.addObject("bills", billService.findAll());
        return modelAndView;
    }

    @GetMapping("/bills/{id}")
    public ModelAndView getDetailBill(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("bill/bill-detail");
        Optional<Bill> bill = billService.getById(id);
        Bill bill1 = bill.get();
        modelAndView.addObject("bill", bill1);
        return modelAndView;
    }

    @GetMapping("/bills-update/{id}")
    public ModelAndView updateDetailBill(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("bill/bill-detail");
        Optional<Bill> bill = billService.getById(id);
        Bill bill1 = bill.get();
        modelAndView.addObject("bill", bill1);
        return modelAndView;
    }
}
