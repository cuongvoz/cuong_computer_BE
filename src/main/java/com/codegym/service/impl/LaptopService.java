package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.ILaptopRepository;
import com.codegym.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LaptopService implements ILaptopService {
    @Autowired
    private ILaptopRepository iLaptopRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iLaptopRepository.getAllLaptop(pageable);
    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        return iLaptopRepository.getAllLaptopAndName(pageable, name);
    }
}
