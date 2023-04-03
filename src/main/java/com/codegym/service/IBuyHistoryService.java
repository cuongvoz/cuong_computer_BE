package com.codegym.service;

import com.codegym.model.bill.Bill;
import com.codegym.model.bill.BuyHistory;
import com.codegym.model.bill.Cart;

import java.util.List;

public interface IBuyHistoryService {
   List<BuyHistory> findAllByBillOrderById(Bill bill);
   void save(BuyHistory buyHistory);
}
