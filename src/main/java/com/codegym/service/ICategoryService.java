package com.codegym.service;

import com.codegym.model.category.Category;

public interface ICategoryService {
    Category findById(Integer id);
}
