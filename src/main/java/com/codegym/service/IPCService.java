package com.codegym.service;

import com.codegym.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPCService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByName(Pageable pageable,String name);
}
