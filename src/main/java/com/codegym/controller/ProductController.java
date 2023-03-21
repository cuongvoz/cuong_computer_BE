package com.codegym.controller;


import com.codegym.model.product.Product;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        return new ResponseEntity<>(iProductService.findById(id),HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<Page<Product>> getAll(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>( iProductService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/all/{name}")
    public ResponseEntity<Page<Product>> findAllByName(@PageableDefault(size = 12)Pageable pageable,@PathVariable("name") String name) {
        return new ResponseEntity<>( iProductService.findAllByName(pageable,name),HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Product>> findAllByCategory(@PageableDefault(size = 12)Pageable pageable,@PathVariable("id") int  id) {
        return new ResponseEntity<>( iProductService.findByCategory(pageable,id),HttpStatus.OK);
    }
    @GetMapping("/category/{id}/{name}")
    public ResponseEntity<Page<Product>> findAllByCategoryAndName(@PageableDefault(size = 12)Pageable pageable,@PathVariable("id") int  id,@PathVariable("name") String name) {
        return new ResponseEntity<>( iProductService.findByCategoryAndName(pageable,id,name),HttpStatus.OK);
    }
}
