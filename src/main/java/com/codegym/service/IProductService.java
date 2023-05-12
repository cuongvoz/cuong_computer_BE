package com.codegym.service;

import com.codegym.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByName(Pageable pageable,String name);
    Product findById(int id);
    Page<Product> findByCategory(Pageable pageable,int id);
    Page<Product> findByCategoryAndName(Pageable pageable, int id,String name);
    void save(Product product);
    Page<Product> hotProduct(Pageable pageable);
    Page<Product> findAllByBrandAndIsDeleteFalseAndCategory_Id(String brand, Integer category_id, Pageable pageable);
    Page<Product> findAllByBrandAndIsDeleteFalse(String brand, Pageable pageable);
    Page<Product> findAllByIsDeleteFalseAndPriceBetween(Double price, Double price2, Pageable pageable);
    Page<Product> findAllByIsDeleteFalseAndPriceBetweenAndCategory_Id(Double price, Double price2, Integer category_id, Pageable pageable);
    Page<Product> findAllByBrandAndCategory(List<Integer> brand,int category ,Pageable pageable);
    Page<Product> findAllByBrand(List<Integer> brand,Pageable pageable);
    boolean existsById(Integer id);
    Page<Product> findAllByIsDeleteFalseAndCpuAndCategory_Id(String[] cpu, Integer category_id, Pageable pageable);
}
