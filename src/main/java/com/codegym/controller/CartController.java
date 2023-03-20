package com.codegym.controller;

import com.codegym.model.bill.Bill;
import com.codegym.model.bill.BillDTO;
import com.codegym.service.IBillService;
import com.codegym.service.IBuyHistoryService;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private IBillService iBillService;
    @Autowired
    private IBuyHistoryService iBuyHistoryService;
    @Autowired
    private IUserService iUserService;
    @RequestMapping
    private ResponseEntity<?> buy(@RequestBody BillDTO billDTO) {
        Bill bill = new Bill();
//        System.out.println(billDTO);
         bill.setUser(iUserService.findById(Integer.parseInt(billDTO.getUserID())));
         bill.setBuyDate(billDTO.getBuyDay());
         bill.setTotalPayment(Double.parseDouble(billDTO.getTotal()));
         iBillService.save(bill);
//        System.out.println(bill.getId());
         iBuyHistoryService.save(billDTO.getCart(),bill);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
