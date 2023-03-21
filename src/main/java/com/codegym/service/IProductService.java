package com.codegym.service;

import com.codegym.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByName(Pageable pageable,String name);
    Product findById(int id);
    Page<Product> findByCategory(Pageable pageable,int id);
    Page<Product> findByCategoryAndName(Pageable pageable, int id,String name);
}
