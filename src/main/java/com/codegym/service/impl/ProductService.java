package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByName(Pageable pageable,String name) {
        return iProductRepository.findAllByName(pageable, name);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).get();
    }
}
