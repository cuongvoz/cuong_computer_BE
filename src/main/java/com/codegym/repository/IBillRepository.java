package com.codegym.repository;

import com.codegym.model.bill.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill,Integer> {
//    @Query(value = "select * from bill where buy_date = :date",nativeQuery = true)
//    Bill findByBuyDay(@Param("date") String buyDay);
    Bill findByBuyDate(String date);
}
