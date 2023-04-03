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
import java.util.List;

@Service
public class BuyHistoryService implements IBuyHistoryService {
    @Autowired
    private IBuyHistory iBuyHistory;
   @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<BuyHistory> findAllByBillOrderById(Bill bill) {
        return iBuyHistory.findAllByBillOrderById(bill);
    }

    @Override
    public void save(BuyHistory buyHistory) {
       iBuyHistory.save(buyHistory);
    }
}
