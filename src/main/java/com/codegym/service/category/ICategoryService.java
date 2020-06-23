package com.codegym.service.category;

import com.codegym.model.Category;
import com.codegym.service.generic.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGenericService<Category> {
    Page<Category> findAll(Pageable pageable);
    Page<Category> findAllByNameContaining(String name,Pageable pageable);
}
