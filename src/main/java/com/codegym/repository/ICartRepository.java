package com.codegym.repository;

import com.codegym.model.bill.Cart;
import com.codegym.model.product.Product;
import com.codegym.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Integer> {
    @Transactional
    void deleteAllByUser(User user);
    List<Cart> getAllByUser(User user);
    Boolean existsByProduct(Product product);

    Cart findByProduct(Product product);
}
