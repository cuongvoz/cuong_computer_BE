package com.codegym.service.impl;

import com.codegym.model.product.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return iProductRepository.findById(id).orElse(null);
    }


    @Override
    public Page<Product> findByCategory(Pageable pageable, int id) {
        return iProductRepository.findByCategory(pageable,id);
    }

    @Override
    public Page<Product> findByCategoryAndName(Pageable pageable, int id, String name) {
        return iProductRepository.findByCategoryAndName(pageable,id,name);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Page<Product> hotProduct(Pageable pageable) {
        return iProductRepository.hotProduct(pageable);
    }

    @Override
    public Page<Product> findAllByBrandAndIsDeleteFalseAndCategory_Id(String brand, Integer category_id, Pageable pageable) {
        return iProductRepository.findAllByBrandAndIsDeleteFalseAndCategory_Id(brand, category_id, pageable);
    }

    @Override
    public Page<Product> findAllByBrandAndIsDeleteFalse(String brand, Pageable pageable) {
        return iProductRepository.findAllByBrandAndIsDeleteFalse(brand, pageable);
    }

    @Override
    public Page<Product> findAllByIsDeleteFalseAndPriceBetween(Double price, Double price2, Pageable pageable) {
        return iProductRepository.findAllByIsDeleteFalseAndPriceBetween(price, price2, pageable);
    }

    @Override
    public Page<Product> findAllByIsDeleteFalseAndPriceBetweenAndCategory_Id(Double price, Double price2, Integer category_id, Pageable pageable) {
        return iProductRepository.findAllByIsDeleteFalseAndPriceBetweenAndCategory_Id(price, price2, category_id, pageable);
    }

    @Override
    public Page<Product> findAllByBrandMouse(List<String> brand, Pageable pageable) {
        return iProductRepository.findAllByBrand(brand, pageable,5);
    }

    @Override
    public Page<Product> findAllByBrandLaptop(List<String> brand, Pageable pageable) {
        return iProductRepository.findAllByBrand(brand, pageable,1);
    }

    @Override
    public Page<Product> findAllByIsDeleteFalseAndCpuAndCategory_Id(String[] cpu, Integer category_id, Pageable pageable) {
        return iProductRepository.findAllByIsDeleteFalseAndCpuAndCategory_Id(cpu[0],cpu[1], category_id, pageable);
    }


}
