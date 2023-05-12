package com.codegym.repository;

import com.codegym.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where name like %:name% and is_delete = false order by price ,id desc", nativeQuery = true)
    Page<Product> findAllByName(Pageable pageable, @Param("name") String name);

    @Query(value = " select p.*  from `product` p join `buy_history` bh on p.id = bh.product_id where p.is_delete = false  group by p.id order by sum(p.id) desc", nativeQuery = true)
    Page<Product> hotProduct(Pageable pageable);

    boolean existsById(Integer id);

    @Query(value = "select * from product where category_id = :id and is_delete =false order by price ,id desc", nativeQuery = true)
    Page<Product> findByCategory(Pageable pageable, @Param("id") int id);

    @Query(value = "select * from product where category_id = :id and is_delete =false and name like %:name% order by price ,id desc", nativeQuery = true)
    Page<Product> findByCategoryAndName(Pageable pageable, @Param("id") int id, @Param("name") String name);

    @Query(value = "select * from product where is_delete = false order by price ,id desc", nativeQuery = true)
    Page<Product> findAll(Pageable pageable);
    @Query(value = "select * from product where category_id = :id and (cpu like %:cpu1% or cpu like %:cpu2%) and is_delete = false order by price ,id desc", nativeQuery = true)
    Page<Product> findAllByIsDeleteFalseAndCpuAndCategory_IdOrderByPriceAscIdDesc(@Param("cpu1") String cpu1,@Param("cpu2") String cpu2,@Param("id") Integer category_id, Pageable pageable);

    Page<Product> findAllByBrandAndIsDeleteFalseAndCategory_IdOrderByPriceAscIdDesc(String brand, Integer category_id, Pageable pageable);

    Page<Product> findAllByBrandAndIsDeleteFalseOrderByPriceAscIdDesc(String brand, Pageable pageable);

    Page<Product> findAllByIsDeleteFalseAndPriceBetweenOrderByPriceAscIdDesc(Double price, Double price2, Pageable pageable);

    Page<Product> findAllByIsDeleteFalseAndPriceBetweenAndCategory_IdOrderByPriceAscIdDesc(Double price, Double price2, Integer category_id, Pageable pageable);

    @Query(value = "select * from product where local_brand_id in (:brand) and category_id = :id and is_delete = false order by price ,id desc", nativeQuery = true)
    Page<Product> findAllByBrandAndCategoryOrderByPrice(@Param("brand") List<Integer> brand, Pageable pageable,@Param("id") int id);
  @Query(value = "select * from product where local_brand_id in (:brand) and is_delete = false order by price ,id desc", nativeQuery = true)
    Page<Product> findAllByBrandOrDOrderByPrice(@Param("brand") List<Integer> brand, Pageable pageable);

}
