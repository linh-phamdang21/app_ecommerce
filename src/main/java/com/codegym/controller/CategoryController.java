package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private  ICategoryService categoryService;

    @GetMapping("list")
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("category/list");
        Iterable<Category> category = categoryService.findAll();
        modelAndView.addObject("categories",category);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView showCreateCategory(){
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView createCategory(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("category/create");
        categoryService.save(category);
        modelAndView.addObject("message","add success category");
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("category/edit");
        Optional<Category> category = categoryService.getById(id);
        if (category != null){
            modelAndView.addObject("category",category);
        }else {
            modelAndView.addObject("category",new Category());
        }

        return modelAndView;
    }
}
