package com.codegym.service.impl;

import com.codegym.model.bill.Bill;
import com.codegym.model.bill.BuyHistory;
import com.codegym.model.bill.Cart;
import com.codegym.repository.IBillRepository;
import com.codegym.repository.IBuyHistory;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IBuyHistoryService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BuyHistoryService implements IBuyHistoryService {
    @Autowired
    private IBuyHistory iBuyHistory;
   @Autowired
    private IProductRepository iProductRepository;
    @Override
    public void save(BuyHistory buyHistory) {
       iBuyHistory.save(buyHistory);
    }
}
