package com.codegym.service;

import com.codegym.model.bill.Cart;
import com.codegym.model.product.Product;
import com.codegym.model.user.User;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();
    void save(Cart cart);
    void save2(Cart cart);
    void deleteAllByUser(User user);
    Cart findById(Integer id);
    List<Cart> getAllByUser(User user);
    Boolean existsByProductAndUser(Product product,User user);
    void deleteById(Integer id);
    Cart findByProductAndUser(Product product,User user);
}
