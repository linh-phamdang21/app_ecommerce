package com.codegym.controller;

import com.codegym.model.Brand;
import com.codegym.model.Product;
import com.codegym.service.Brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private IBrandService brandService;
//    @GetMapping("list")
//    public ModelAndView showList(){
//        ModelAndView modelAndView = new ModelAndView("brand/list");
//        Iterable<Brand> brands = brandService.findAll();
//        modelAndView.addObject("brands",brands);
//        return modelAndView;
//    }
    @GetMapping("/list")
    public ModelAndView listProduct(@RequestParam("s") Optional<String> s,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Brand> brands;
        if (s.isPresent()) {
            brands = brandService.findAllByNameContaining(s.get(), pageable);
        } else {
            brands = brandService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("brand/list");
        modelAndView.addObject("brands", brands);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreateBrand(){
        ModelAndView modelAndView = new ModelAndView("brand/create");
        modelAndView.addObject("brand",new Brand());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView createBrand(@ModelAttribute Brand brand){
        brandService.save(brand);
        return new ModelAndView("redirect:/brand/list");
    }
}
