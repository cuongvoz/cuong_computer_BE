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
    @Query(value = "select * from product where name like %:name% and is_delete = false",nativeQuery = true)
    Page<Product> findAllByName(Pageable pageable,@Param("name") String name);

    @Query(value = "select * from product where category_id = :id and is_delete =false",nativeQuery = true)
    Page<Product> findByCategory(Pageable pageable, @Param("id") int id);
    @Query(value = "select * from product where category_id = :id and is_delete =false and name like %:name%",nativeQuery = true)
    Page<Product> findByCategoryAndName(Pageable pageable, @Param("id") int id,@Param("name") String name);

    @Query(value = "select * from product where is_delete = false",nativeQuery = true)
   Page<Product> findAll(Pageable pageable);
}
