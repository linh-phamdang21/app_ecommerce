package com.codegym.service.type;

import com.codegym.model.ProductType;
import com.codegym.repository.ITypeReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    private ITypeReposity typeReposity;

    @Override
    public Page<ProductType> findAll(Pageable pageable) {
        return typeReposity.findAll(pageable);
    }

    @Override
    public Page<ProductType> findAllByNameContaining(String name, Pageable pageable) {
        return typeReposity.findAllByNameContaining(name, pageable);
    }

    @Override
    public Iterable<ProductType> findAll() {
        return typeReposity.findAll();
    }

    @Override
    public Optional getById(Long id) {
        return Optional.empty();
    }

    public ProductType save(ProductType productType) {
        return typeReposity.save(productType);
    }

    public void remove(Long id) {
        typeReposity.deleteById(id);
    }
}
