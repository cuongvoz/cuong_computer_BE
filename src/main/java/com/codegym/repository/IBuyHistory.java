package com.codegym.repository;

import com.codegym.model.bill.Bill;
import com.codegym.model.bill.BuyHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface IBuyHistory extends JpaRepository<BuyHistory,Integer> {
    List<BuyHistory> findAllByBillOrderById(Bill bill);
}
