package com.codegym.formatter;

import com.codegym.model.Brand;
import com.codegym.model.Category;
import com.codegym.service.Brand.BrandService;
import com.codegym.service.Brand.IBrandService;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class BrandFormatter implements Formatter<Brand> {
    @Autowired
    private IBrandService brandService;

    @Autowired
    public BrandFormatter(BrandService brandService){
        this.brandService=brandService;
    }

    @Override
    public Brand parse(String text, Locale locale) throws ParseException {
        return brandService.getById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Brand object, Locale locale) {
        return null;
    }
}
