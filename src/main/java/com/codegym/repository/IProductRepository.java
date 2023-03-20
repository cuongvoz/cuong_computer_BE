package com.codegym.repository;

import com.codegym.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product where name like %:name%",nativeQuery = true)
    Page<Product> findAllByName(Pageable pageable,@Param("name") String name);
}
