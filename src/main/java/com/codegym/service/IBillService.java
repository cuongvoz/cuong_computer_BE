package com.codegym.service;

import com.codegym.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBillService {
   void save(Bill bill);
        Bill findById(Integer id);
    Page<Bill> findAll(Pageable pageable);
    Page<Bill> findAllByUser_IdOrOrderByIdDesc(Pageable pageable, Integer id);
}
