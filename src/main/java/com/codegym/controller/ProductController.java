package com.codegym.controller;

import com.codegym.model.Brand;
import com.codegym.model.Category;
import com.codegym.model.Product;

import com.codegym.service.Brand.IBrandService;

import com.codegym.model.ProductType;
import com.codegym.repository.ITypeReposity;

import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProduceService;
import com.codegym.service.type.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private IProduceService produceService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    Environment env;

    @ModelAttribute("brand")
    public Iterable<Brand> brands() {
        return brandService.findAll();
    }

    @Autowired
    private IProductTypeService typeService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("types")
    public Iterable<ProductType> types() {
        return typeService.findAll();
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
        modelAndView.addObject("types",  types());
        return modelAndView;
    }
//
//    @PostMapping("/create-product")
//    public ModelAndView createProduct(@ModelAttribute Product product) {
//        ModelAndView modelAndView = new ModelAndView("/product/createProduct");
//        produceService.save(product);
//        modelAndView.addObject("message", "create success");
//        return modelAndView;
//    }
    @PostMapping("/create-product")
    public ModelAndView saveFile(@ModelAttribute Product product) throws Exception {
        ModelAndView modelAndView = new ModelAndView("product/createProduct");
        Product product1 = new Product(null,product.getProductName(),product.getPrice(),product.getDescribes(),
                product.getCategory(),product.getBrand(),product.getType());
        MultipartFile multipartFile = product.getImages();
        String fileName= multipartFile.getOriginalFilename();
        String fileUpLoad= env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(product.getImages().getBytes(), new File(fileUpLoad + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product1.setImage(fileName);
        Product product2 = produceService.save(product1);
        if (product2 == null) {
            modelAndView.addObject("message", "errors");
        } else {
            modelAndView.addObject("message", "ok");
        }
        modelAndView.addObject("product", new Product());

        return modelAndView;

    }

    @GetMapping("edit-product/{id}")
    public ModelAndView showEditProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/product/editProduct");
        Optional<Product> product = produceService.getById(id);
        if (product.isPresent()) {
            Product product1 = new Product();
            product1 = product.get();
            modelAndView.addObject("product", product1);
        } else {
            modelAndView.addObject("product", new Product());
        }

        return modelAndView;
    }

    @PostMapping("edit-product")
    public ModelAndView editProduct(@ModelAttribute Product products) {
        ModelAndView modelAndView = new ModelAndView("/product/editProduct");
        if (products.getId() != null) {
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
        return new ModelAndView("redirect:/admin/product/list");
    }
}
