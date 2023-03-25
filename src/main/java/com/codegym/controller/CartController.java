package com.codegym.controller;

import com.codegym.model.bill.*;
import com.codegym.service.IBillService;
import com.codegym.service.IBuyHistoryService;
import com.codegym.service.ICartService;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @Autowired
    private ICartService iCartService;

    @GetMapping("/{id}")
    private ResponseEntity<List<Cart>> getAllByUser(@PathVariable("id") Integer id) {
        System.out.println("id ="  + id);
        System.out.println(iCartService.getAllByUser(iUserService.findById(id).orElse(null)));
        return new ResponseEntity<>(iCartService.getAllByUser(iUserService.findById(id).orElse(null)),HttpStatus.OK);
    }
    @PostMapping("/add")
    private ResponseEntity<?> addToCart(@RequestBody Cart cart) {
        iCartService.save(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/change/{operator}/{id}")
    private ResponseEntity<?> change(@PathVariable("operator") String operator, @PathVariable("id") int id) {
        Cart cart = iCartService.findById(id);
        if (Objects.equals(operator, "-")) {
            System.out.println(operator);
            if (cart.getQuantity() == 1) {
                this.iCartService.deleteById(id);
                System.out.println("alo trên nè");
            } else {
                Cart cart2 = iCartService.findById(id);
                cart2.setQuantity(cart2.getQuantity()-1);
                iCartService.save2(cart2);
                System.out.println("dưới nè");
            }
        } else {
            cart.setQuantity(cart.getQuantity() + 1);
            iCartService.save2(cart);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    private ResponseEntity<?> deleteCart( @PathVariable("id") int id) {
                this.iCartService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/drop/{id}")
    private ResponseEntity<?> dropCart( @PathVariable("id") int id) {
        this.iCartService.deleteAllByUser(iUserService.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/buy")
    private ResponseEntity<?> buy(@RequestBody BuyDTO buyDTO) {
        Bill bill = new Bill();
        bill.setUser(iUserService.findById(buyDTO.getId()));
        bill.setQuantity(buyDTO.getQuantity());
        bill.setTotalPayment(buyDTO.getTotal());
        bill.setBuyDate(buyDTO.getTime());
        iBillService.save(bill);
        List<Cart> carts = iCartService.getAllByUser(iUserService.findById(buyDTO.getId()));
        for (int i = 0; i < carts.size(); i++) {
            BuyHistory buyHistory = new BuyHistory(carts.get(i).getProduct(),bill,carts.get(i).getQuantity());
            iBuyHistoryService.save(buyHistory);
        }
        iCartService.deleteAllByUser(iUserService.findById(buyDTO.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
