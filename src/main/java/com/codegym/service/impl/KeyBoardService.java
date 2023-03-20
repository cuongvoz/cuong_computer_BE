package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.IKeyBoardRepository;
import com.codegym.service.IKeyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KeyBoardService implements IKeyBoardService {
    @Autowired
    private IKeyBoardRepository iKeyBoardRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iKeyBoardRepository.getAllKeyBoard(pageable);
    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        return iKeyBoardRepository.getAllKeyBoardAndName(pageable, name);
    }
}
