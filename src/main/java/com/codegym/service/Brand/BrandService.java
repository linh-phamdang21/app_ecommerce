package com.codegym.service.Brand;

import com.codegym.model.Brand;
import com.codegym.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;

    @Override
    public Iterable<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> getById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand save(Brand model) {
        return brandRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Page<Brand> findAllByNameContaining(String name, Pageable pageable) {
        return brandRepository.findAllByNameContaining(name,pageable);
    }
}
