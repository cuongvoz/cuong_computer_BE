package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.IMonitorRepository;
import com.codegym.service.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MonitorService implements IMonitorService {
    @Autowired
    private IMonitorRepository iMonitorRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iMonitorRepository.getAllMonitor(pageable);
    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        return iMonitorRepository.getAllMonitorAndName(pageable, name);
    }
}
