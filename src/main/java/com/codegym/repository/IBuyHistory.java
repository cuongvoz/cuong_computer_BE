package com.codegym.repository;

import com.codegym.model.bill.Bill;
import com.codegym.model.bill.BuyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBuyHistory extends JpaRepository<BuyHistory,Integer> {

}
