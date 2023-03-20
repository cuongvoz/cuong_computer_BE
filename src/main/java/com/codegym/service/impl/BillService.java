package com.codegym.service.impl;

import com.codegym.model.bill.Bill;
import com.codegym.repository.IBillRepository;
import com.codegym.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository iBillRepository;


    @Override
    public void save(Bill bill) {
        iBillRepository.save(bill);
    }

    @Override
    public Bill findByDate(String date) {
        return iBillRepository.findByBuyDate(date);
    }
}
