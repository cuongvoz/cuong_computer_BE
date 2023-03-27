package com.codegym.service.impl;

import com.codegym.model.bill.Cart;
import com.codegym.model.product.Product;
import com.codegym.model.user.User;
import com.codegym.repository.ICartRepository;
import com.codegym.service.ICartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
   @Autowired
   private ICartRepository iCartRepository;

    @Override
    public List<Cart> findAll() {
        return iCartRepository.findAll();
    }

    @Override
    public void save(Cart cart) {
        if (existsByProductAndUser(cart.getProduct(), cart.getUser())) {
            Cart cart1 = iCartRepository.findByProductAndUser(cart.getProduct(),cart.getUser());
            int quantity = cart1.getQuantity();
            cart1.setQuantity(quantity+= 1);
            iCartRepository.save(cart1);
        } else {
            iCartRepository.save(cart);
        }
    }

    @Override
    public void save2(Cart cart) {
        iCartRepository.save(cart);
    }

    @Override
    public void deleteAllByUser(User user) {
        iCartRepository.deleteAllByUser(user);
    }

    @Override
    public Cart findById(Integer id) {
        return iCartRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getAllByUser(User user) {
        return iCartRepository.getAllByUser(user);
    }

    @Override
    public Boolean existsByProductAndUser(Product product,User user) {
        return iCartRepository.existsByProductAndUser(product,user);
    }

    @Override
    public void deleteById(Integer id) {
        iCartRepository.deleteById(id);
    }

    @Override
    public Cart findByProductAndUser(Product product, User user) {
        return iCartRepository.findByProductAndUser(product, user);
    }
}
