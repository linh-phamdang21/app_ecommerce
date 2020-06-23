package com.codegym.controller;

import com.codegym.model.Brand;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView listBrand(@RequestParam("s") Optional<String> s,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories;
        if (s.isPresent()) {
            categories = categoryService.findAllByNameContaining(s.get(), pageable);
        } else {
            categories = categoryService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreateCategory() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView createCategory(@ModelAttribute Category category) {
        ModelAndView modelAndView = new ModelAndView("category/create");
        categoryService.save(category);
        modelAndView.addObject("message", "add success category");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id) {
        categoryService.remove(id);
        return new ModelAndView("redirect:/category/list");
    }
}
