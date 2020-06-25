package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IProductRepository  extends PagingAndSortingRepository<Product ,Long> {

    Page<Product> findAllByProductNameContaining(String productName, Pageable pageable);

    Page<Product> findAllByType_Name(String productType, Pageable pageable);

    Page<Product> findAllByType_NameAndPriceBetween(String productType, float lowPrice, float highPrice, Pageable pageable);

    Page<Product> findAllByType_NameOrderByPrice(String productType, Pageable pageable);

    Page<Product> findAllByType_NameOrderByPriceAsc(String productType, Pageable pageable);

    Page<Product> findAllByType_NameOrderByPriceDesc(String type, Pageable pageble);

    Page<Product> findAllByCategory_NameAndPriceBetween(String category, float lowPrice, float highPrice, Pageable pageable);

    Page<Product> findAllByCategory_NameOrderByPriceAsc(String category, Pageable pageable);
}
