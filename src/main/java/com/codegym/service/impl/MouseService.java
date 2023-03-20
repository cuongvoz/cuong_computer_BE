package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.IMouseRepository;
import com.codegym.service.IMouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MouseService implements IMouseService {
    @Autowired
    private IMouseRepository iMouseRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iMouseRepository.getAllMouse(pageable);
    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        return iMouseRepository.getAllMouseAndName(pageable, name);
    }
}
