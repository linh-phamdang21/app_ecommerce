package com.codegym.controller;

import com.codegym.model.AppCustomer;
import com.codegym.model.AppRole;
import com.codegym.service.approle.AppRoleService;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private AppRoleService appRoleService;

    @GetMapping("/loginForm")
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView = new ModelAndView("loginForm");
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/do_register")
    public ModelAndView showRegisterForm(){
        ModelAndView modelAndView = new ModelAndView("customer/registerForm");
        AppCustomer appCustomer = new AppCustomer();
        modelAndView.addObject("newCustomer", appCustomer);
        return modelAndView;
    }

    @PostMapping("/do_register")
    public ModelAndView createCustomer(@ModelAttribute("newCustomer") AppCustomer appCustomer){
        AppRole appRole = appRoleService.getRoleById((long) 1);
        appCustomer.setAppRole(appRole);
        customerService.save(appCustomer);
        ModelAndView modelAndView = new ModelAndView("customer/registerForm");
        modelAndView.addObject("message", "Add new customer successfully!");
        return modelAndView;
    }

    @GetMapping("/customer_list")
    public ModelAndView showCustomerList(){
        Iterable<AppCustomer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/customerList");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customer_edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
            ModelAndView modelAndView = new ModelAndView("customer/customerEdit");
            modelAndView.addObject("customer", customerService.getById(id));
            return modelAndView;
    }

    @PostMapping("/customer_edit")
    public String editCustomer(@ModelAttribute("customer") AppCustomer customer){
        customerService.save(customer);
        return "redirect:/customer_list";
    }

    @GetMapping("/customer_delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("customer/customerDelete");
        modelAndView.addObject("customer", customerService.getById(id));
        return modelAndView;
    }

    @PostMapping("/customer_delete")
    public String deleteCustomer(@ModelAttribute("customer") AppCustomer customer){
        customerService.remove(customer.getId());
        return "redirect:/customer_list";
    }
}
