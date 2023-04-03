package com.codegym.repository;

import com.codegym.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill,Integer> {

    @Query(value = "select * from bill where user_id = :id order by id desc ",nativeQuery = true)
    Page<Bill> findAllByUser_IdOrOrderByIdDesc(Pageable pageable,@Param("id") Integer id);
    @Query(value = "select * from bill order by id desc ",nativeQuery = true)
    Page<Bill> findAll(Pageable pageable);
}
