package com.codegym.controller;

import com.codegym.model.Brand;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.Brand.IBrandService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProduceService produceService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBrandService brandService;

    @ModelAttribute("brand")
    public Iterable<Brand> brands(){
        return brandService.findAll();
    }

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listProduct(@RequestParam("s") Optional<String> s,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products;
        if (s.isPresent()) {
            products = produceService.findAllByProductNameContaining(s.get(), pageable);
        } else {
            products = produceService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("product/listProduct");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateProduct() {
        ModelAndView modelAndView = new ModelAndView("/product/createProduct");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("/product/createProduct");
        produceService.save(product);
        modelAndView.addObject("message", "create success");
        return modelAndView;
    }

    @GetMapping("edit-product/{id}")
    public ModelAndView showEditProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/product/editProduct");
        Optional<Product> product = produceService.getById(id);
        if (product.isPresent()){
            Product product1 = new Product();
            product1 = product.get();
            modelAndView.addObject("product", product1);
        }else {
            modelAndView.addObject("product", new Product());
        }

        return modelAndView;
    }

    @PostMapping("edit-product")
    public ModelAndView editProduct(@ModelAttribute Product products) {
        ModelAndView modelAndView = new ModelAndView("/product/editProduct");
        Product product = produceService.save(products);
        if (product != null) {
            modelAndView.addObject("edit", "Edit success");
        } else {
            modelAndView.addObject("edit", "Edit no success");
        }
        produceService.save(products);
        return modelAndView;
    }

    @GetMapping("delete-product/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id) {
        produceService.remove(id);
        return new ModelAndView("redirect:/product/list");
    }
}
