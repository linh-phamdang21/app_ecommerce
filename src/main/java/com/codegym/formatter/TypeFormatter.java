package com.codegym.formatter;

import com.codegym.model.Category;

import com.codegym.model.ProductType;
import com.codegym.service.type.IProductTypeService;
import com.codegym.service.type.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class TypeFormatter implements Formatter<ProductType> {


    @Autowired
    private IProductTypeService typeService;

    @Autowired
    private TypeFormatter(ProductTypeServiceImpl typeService){
        this.typeService = typeService;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        return typeService.getById(Long.parseLong(text)).get();

    }

    @Override
    public String print(ProductType object, Locale locale) {
        return null;
    }
}
