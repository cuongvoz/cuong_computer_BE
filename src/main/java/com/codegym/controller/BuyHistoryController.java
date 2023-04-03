package com.codegym.controller;

import com.codegym.model.bill.BuyHistory;
import com.codegym.service.IBillService;
import com.codegym.service.IBuyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/buyHistory")
public class BuyHistoryController {
    @Autowired
    private IBuyHistoryService iBuyHistoryService;
     @Autowired
     private IBillService iBillService;
    @GetMapping("/check/{id}")
    public ResponseEntity<List<BuyHistory>> checkBuyBill(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(iBuyHistoryService.findAllByBillOrderById(iBillService.findById(id)), HttpStatus.OK);
    }
}
