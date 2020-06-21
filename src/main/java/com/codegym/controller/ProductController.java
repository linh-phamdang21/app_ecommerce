package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.product.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProduceService produceService;

    @GetMapping("/list")
    public ModelAndView showListProduct(){
        ModelAndView modelAndView = new ModelAndView("/product/listProduct");
        Iterable<Product> products = produceService.findAll();
        modelAndView.addObject("product",products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateProduct(){
        ModelAndView modelAndView = new ModelAndView("/product/createProduct");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/create-product")
    public ModelAndView  createProduct(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("/product/listProduct");
        produceService.save(product);
        modelAndView.addObject("product",produceService.findAll());
        return modelAndView;
    }
    @GetMapping("edit-product/{id}")
    public ModelAndView showEditProduct(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/product/editProduct");
        modelAndView.addObject("products",produceService.getById(id));
        return  modelAndView;
    }
    @PostMapping("edit-product")
    public  ModelAndView editProduct(@ModelAttribute Product products){
        ModelAndView modelAndView = new ModelAndView("/product/listProduct");
        produceService.save(products);
        modelAndView.addObject("product",produceService.findAll());
        return modelAndView;
    }
    @GetMapping("delete-product/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/product/listProduct");
        produceService.remove(id);
        modelAndView.addObject("product",produceService.findAll());
        return  modelAndView;
    }
}
