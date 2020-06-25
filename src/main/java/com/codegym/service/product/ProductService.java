package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProduceService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product model) {
        return productRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByProductNameContaining(String productName, Pageable pageable) {
        return productRepository.findAllByProductNameContaining(productName,pageable);
    }

    @Override
    public Page<Product> findAllByType_Name(String typeName, Pageable pageable) {
        return productRepository.findAllByType_Name(typeName, pageable);
    }

    @Override
    public Page<Product> findAllByType_NameAndPriceBetween(String typeName, float lowPrice, float highPrice, Pageable pageable) {
        return productRepository.findAllByType_NameAndPriceBetween(typeName, lowPrice, highPrice,pageable);
    }

    @Override
    public Page<Product> findAllByType_NameOrderByPrice(String type, Pageable pageable) {
        return productRepository.findAllByType_NameOrderByPrice(type, pageable);
    }

    @Override
    public Page<Product> findAllByType_NameOrderByPriceAsc(String typeName, Pageable pageble) {
        return productRepository.findAllByType_NameOrderByPriceAsc(typeName, pageble);
    }

    @Override
    public Page<Product> findAllByType_NameOrderByPriceDesc(String type, Pageable pageble) {
        return productRepository.findAllByType_NameOrderByPriceDesc(type, pageble);
    }

    @Override
    public Page<Product> findAllByCategory_NameAndPriceBetween(String category, float lowPrice, float highPrice, Pageable pageable) {
        return productRepository.findAllByCategory_NameAndPriceBetween(category, lowPrice, highPrice, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_NameOrderByPriceAsc(String category, Pageable pageable) {
        return productRepository.findAllByCategory_NameOrderByPriceAsc(category, pageable);
    }
}
