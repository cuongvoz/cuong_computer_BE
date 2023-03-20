package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.IChairRepository;
import com.codegym.repository.ILaptopRepository;
import com.codegym.service.IChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChairService implements IChairService {
    @Autowired
    private IChairRepository iChairRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iChairRepository.getAllChair(pageable);
    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        return iChairRepository.getAllChairAndName(pageable, name);
    }
}
