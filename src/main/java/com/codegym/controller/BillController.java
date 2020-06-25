package com.codegym.controller;

import com.codegym.model.Bill;
import com.codegym.model.BillStatus;
import com.codegym.model.Product;
import com.codegym.service.bill.IBillService;
import com.codegym.service.billStatus.IBillStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BillController {

    @Autowired
    private IBillService billService;
    @Autowired
    private IBillStatusService billStatusService;

    @GetMapping("/bills")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("bill/list");
        modelAndView.addObject("bills", billService.findAll());
        return modelAndView;
    }

    @ModelAttribute("billStatuses")
    public Iterable<BillStatus> billStatuses() {
        return billStatusService.findAll();
    }

    @ModelAttribute("billStatuses")
    public Iterable<BillStatus> getBillStatus() {
        return billStatusService.findAll();
    }

    @GetMapping("/bills/{id}")
    public ModelAndView getDetailBill(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("bill/bill-detail");
        Optional<Bill> bill = billService.getById(id);
        if (bill.isPresent()){
            Bill bill1 = new Bill();
            bill1 = bill.get();
            modelAndView.addObject("bill", bill1);
        }else {
            modelAndView.addObject("billStatuses", new Bill());
        }
        return modelAndView;

    }

    @PostMapping("/bills-update")
    public ModelAndView updateDetailBill(@ModelAttribute("bill") Bill bill) {
        ModelAndView modelAndView = new ModelAndView("bill/bill-detail");
        if (bill.getId() != null){
            System.out.println(bill.getId());
            modelAndView.addObject("message", "Edit success");
        }else {
            modelAndView.addObject("message", "Edit no success");
        }
        Optional<Bill> bill1 = billService.getById(bill.getId());
        Bill bill2 = bill1.get();
        bill2.setStatus(bill.getStatus());
        billService.save(bill2);
        modelAndView.addObject("bill", bill2);
        return modelAndView;
    }

}
