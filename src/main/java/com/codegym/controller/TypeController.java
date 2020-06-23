package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.ProductType;
import com.codegym.repository.ITypeReposity;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.type.IProductTypeService;
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
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private ITypeReposity typeReposity;

    @Autowired
    private IProductTypeService productTypeService;

    @ModelAttribute("type")
    public Iterable<ProductType> productTypes(){
        return productTypeService.findAll();
    }

    @GetMapping("list")
    public ModelAndView listType (@RequestParam("s") Optional<String> s,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size)
    {
        Pageable pageable = PageRequest.of(page,size);
        Page<ProductType> types;
        if (s.isPresent()){
            types = typeReposity.findAllByNameContaining(s.get(), pageable);
        } else {
            types = typeReposity.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("type/list");
        modelAndView.addObject("types", types);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView showCreateType(){
        ModelAndView modelAndView = new ModelAndView("type/create");
        modelAndView.addObject("type",new ProductType());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView createProductType(@ModelAttribute ProductType type){
        ModelAndView modelAndView = new ModelAndView("type/create");
        typeReposity.save(type);
        modelAndView.addObject("message","add success product type");
        return modelAndView;
    }

//    @GetMapping("edit/{id}")
//    public ModelAndView showEdit(@PathVariable Long id){
//        ModelAndView modelAndView = new ModelAndView("type/edit");
//        Optional<ProductType> type = typeReposity.findById(id);
//        if (type != null){
//            modelAndView.addObject("type",type);
//        }else {
//            modelAndView.addObject("type",new ProductType());
//        }
//        return modelAndView;
//    }
}
