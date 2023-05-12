package com.codegym.service.impl;

import com.codegym.model.bill.Bill;
import com.codegym.repository.IBillRepository;
import com.codegym.repository.Revenue;
import com.codegym.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository iBillRepository;


    @Override
    public void save(Bill bill) {
        iBillRepository.save(bill);
    }


    @Override
    public Bill findById(Integer id) {
        return iBillRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return iBillRepository.findAll(pageable);
    }

    @Override
    public Page<Bill> findAllByUser_IdOrOrderByIdDesc(Pageable pageable, Integer id) {
        return iBillRepository.findAllByUser_IdOrOrderByIdDesc(pageable, id);
    }

    @Override
    public List<Revenue> getSaleReport() {
        return iBillRepository.getSaleReport();
    }
}
