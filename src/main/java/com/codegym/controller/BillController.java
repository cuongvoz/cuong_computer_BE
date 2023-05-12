package com.codegym.controller;

import com.codegym.model.bill.Bill;
import com.codegym.repository.Revenue;
import com.codegym.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private IBillService iBillService;
   @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @RequestMapping
    public ResponseEntity<Page<Bill>> findAll(@PageableDefault(value = 5)Pageable pageable) {
        return new ResponseEntity<>(iBillService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<Page<Bill>> findAllByUser(@PageableDefault(value = 5)Pageable pageable, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(iBillService.findAllByUser_IdOrOrderByIdDesc(pageable,id), HttpStatus.OK);
    }
    @GetMapping("/sale")
    public ResponseEntity<List<Revenue>> getSaleReport() {
        return new ResponseEntity<>(iBillService.getSaleReport(), HttpStatus.OK);
    }
}
