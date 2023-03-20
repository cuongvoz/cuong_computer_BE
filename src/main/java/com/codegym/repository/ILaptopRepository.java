package com.codegym.repository;

import com.codegym.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select p.* from `product` p join `category` c on p.category_id = c.id where c.id = 1 and p.name like %:name%",nativeQuery = true)
    Page<Product> getAllLaptopAndName(Pageable pageable, @Param("name") String name);
    @Query(value = "select p.* from `product` p join `category` c on p.category_id = c.id where c.id = 1 ",nativeQuery = true)
    Page<Product> getAllLaptop(Pageable pageable);
}
