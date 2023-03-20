package com.codegym.service;

import com.codegym.model.bill.Bill;

public interface IBillService {
   void save(Bill bill);
        Bill findByDate(String date);
}
