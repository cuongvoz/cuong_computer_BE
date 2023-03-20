package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.IPCRepository;
import com.codegym.service.IPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PCService implements IPCService {
    @Autowired
    private IPCRepository ipcRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return ipcRepository.getAllPC(pageable);
    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        return ipcRepository.getAllPCAndName(pageable, name);
    }
}
