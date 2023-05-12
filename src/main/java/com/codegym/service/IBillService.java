package com.codegym.service;

import com.codegym.model.bill.Bill;
import com.codegym.repository.Revenue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBillService {
   void save(Bill bill);
        Bill findById(Integer id);
    Page<Bill> findAll(Pageable pageable);
    Page<Bill> findAllByUser_IdOrOrderByIdDesc(Pageable pageable, Integer id);
    List<Revenue> getSaleReport();
}
