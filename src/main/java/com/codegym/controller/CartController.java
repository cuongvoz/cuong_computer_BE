package com.codegym.controller;

import com.codegym.model.bill.*;
import com.codegym.model.product.Product;
import com.codegym.service.*;
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
    @Autowired
    private IProductService iProductService;

    @GetMapping("/{id}")
    private ResponseEntity<List<Cart>> getAllByUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(iCartService.getAllByUser(iUserService.findById(id)), HttpStatus.OK);
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
                cart2.setQuantity(cart2.getQuantity() - 1);
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
    private ResponseEntity<?> deleteCart(@PathVariable("id") int id) {
        this.iCartService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/drop/{id}")
    private ResponseEntity<?> dropCart(@PathVariable("id") int id) {
        this.iCartService.deleteAllByUser(iUserService.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/buyDetail")
    private ResponseEntity<?> buyDetail(@RequestBody PutDto putDto) {
        if (Objects.equals(putDto.getType(), "add")) {
            if (!iCartService.existsByProductAndUser(iProductService.findById(putDto.getId()), iUserService.findById(putDto.getIdUser()))) {
                Cart cart = new Cart();
                cart.setQuantity(putDto.getQuantity());
                cart.setProduct(iProductService.findById(putDto.getId()));
                cart.setUser(iUserService.findById(putDto.getIdUser()));
                iCartService.save2(cart);
            } else {
                Cart cart = iCartService.findByProductAndUser(iProductService.findById(putDto.getId()), iUserService.findById(putDto.getIdUser()));
                int quantity = cart.getQuantity() + putDto.getQuantity();
                cart.setQuantity(quantity);
                iCartService.save2(cart);
            }
        } else {
            if (!iCartService.existsByProductAndUser(iProductService.findById(putDto.getId()), iUserService.findById(putDto.getIdUser()))) {
                Cart cart = new Cart();
                cart.setQuantity(putDto.getQuantity());
                cart.setProduct(iProductService.findById(putDto.getId()));
                cart.setUser(iUserService.findById(putDto.getIdUser()));
                iCartService.save2(cart);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/buy")
    private ResponseEntity<?> buy(@RequestBody BuyDTO buyDTO) {
        Bill bill = new Bill();
        bill.setUser(iUserService.findById(buyDTO.getId()));
        bill.setQuantity(buyDTO.getQuantity());
        bill.setTotalPayment(buyDTO.getTotal());
        bill.setBuyDate(buyDTO.getTime());
        bill.setNote(buyDTO.getNote());
        bill.setEmail(buyDTO.getEmail());
        bill.setName(buyDTO.getName());
        bill.setAddress(buyDTO.getAddress());
        bill.setPhoneNumber(buyDTO.getPhoneNumber());
        iBillService.save(bill);
        List<Cart> carts = iCartService.getAllByUser(iUserService.findById(buyDTO.getId()));
        for (int i = 0; i < carts.size(); i++) {
            BuyHistory buyHistory = new BuyHistory(carts.get(i).getProduct(), bill, carts.get(i).getQuantity());
            Product product = carts.get(i).getProduct();
            product.setQuantity(product.getQuantity() - carts.get(i).getQuantity());
            iProductService.save(product);
            iBuyHistoryService.save(buyHistory);
        }
        iCartService.deleteAllByUser(iUserService.findById(buyDTO.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/userCart")
    public ResponseEntity<?> setCartToUser(@RequestBody CartUserDto cartUserDto) {
        System.out.println(cartUserDto);
        for (int i = 0; i < cartUserDto.getCarts().length; i++) {
            if (iCartService.existsByProductAndUser(iProductService.findById(cartUserDto.getCarts()[i].getProduct().getId()), iUserService.findById(cartUserDto.getId()))) {
                Cart cart = iCartService.findByProductAndUser(iProductService.findById(cartUserDto.getCarts()[i].getProduct().getId()) , iUserService.findById(cartUserDto.getId()));
                cart.setQuantity(cart.getQuantity() + cartUserDto.getCarts()[i].getQuantity());
                iCartService.save2(cart);
            } else {
                Cart cart = new Cart();
                cart.setUser(iUserService.findById(cartUserDto.getId()));
                cart.setQuantity(cartUserDto.getCarts()[i].getQuantity());
                cart.setProduct(cartUserDto.getCarts()[i].getProduct());
                iCartService.save2(cart);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
