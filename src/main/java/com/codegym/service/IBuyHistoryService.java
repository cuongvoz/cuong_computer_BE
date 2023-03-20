package com.codegym.service;

import com.codegym.model.bill.Bill;
import com.codegym.model.bill.Cart;

public interface IBuyHistoryService {

   void save(Cart[] cart, Bill bill);
}
