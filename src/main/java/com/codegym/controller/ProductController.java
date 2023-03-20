package com.codegym.controller;

import com.codegym.model.product.Product;
import com.codegym.repository.IChairRepository;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ILaptopService iLaptopService;
    @Autowired
    private IProductService iProductService;
   @Autowired
   private IChairService iChairService;
    @Autowired
    private IMonitorService iMonitorService;
    @Autowired
    private IKeyBoardService iKeyBoardService;
    @Autowired
    private IPCService ipcService;
    @Autowired
    private IMouseService iMouseService;
    @RequestMapping
    public ResponseEntity<Page<Product>> getHome(@PageableDefault(size = 8)Pageable pageable) {
        return new ResponseEntity<>(iProductService.findAll(pageable), HttpStatus.OK);
    }
    @RequestMapping("/list")
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>(iProductService.findAll(pageable), HttpStatus.OK);
    }
    @RequestMapping("/list/search/{name}")
    public ResponseEntity<Page<Product>> searchProduct(@PageableDefault(size = 12)Pageable pageable, @PathVariable("name") String name) {
        return new ResponseEntity<>(iProductService.findAllByName(pageable, name), HttpStatus.OK);
    }


    @RequestMapping("/laptops")
    public ResponseEntity<Page<Product>> getAllLaptop(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>(iLaptopService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/laptops/search/{name}")
    public ResponseEntity<Page<Product>> searchLaptop(@PageableDefault(size = 12) Pageable pageable, @PathVariable("name") String name) {
        return new ResponseEntity<>(iLaptopService.findByName(pageable, name),HttpStatus.OK);
    }

    @RequestMapping("/chairs")
    public ResponseEntity<Page<Product>> getAllChair(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>(iChairService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/chairs/search/{name}")
    public ResponseEntity<Page<Product>> searchChair(@PageableDefault(size = 12) Pageable pageable, @PathVariable("name") String name) {
        return new ResponseEntity<>(iChairService.findByName(pageable, name),HttpStatus.OK);
    }
    @RequestMapping("/monitors")
    public ResponseEntity<Page<Product>> getAllMonitor(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>(iMonitorService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/monitors/search/{name}")
    public ResponseEntity<Page<Product>> searchMonitor(@PageableDefault(size = 12) Pageable pageable, @PathVariable("name") String name) {
        return new ResponseEntity<>(iMonitorService.findByName(pageable, name),HttpStatus.OK);
    }
    @RequestMapping("/keyboards")
    public ResponseEntity<Page<Product>> getAllKeyboard(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>(iKeyBoardService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/keyboards/search/{name}")
    public ResponseEntity<Page<Product>> searchKeyboard(@PageableDefault(size = 12) Pageable pageable, @PathVariable("name") String name) {
        return new ResponseEntity<>(iKeyBoardService.findByName(pageable, name),HttpStatus.OK);
    }
    @RequestMapping("/pc")
    public ResponseEntity<Page<Product>> getAllPC(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>(ipcService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/pc/search/{name}")
    public ResponseEntity<Page<Product>> searchPC(@PageableDefault(size = 12) Pageable pageable, @PathVariable("name") String name) {
        return new ResponseEntity<>(ipcService.findByName(pageable, name),HttpStatus.OK);
    }
    @RequestMapping("/mouse")
    public ResponseEntity<Page<Product>> getAllMouse(@PageableDefault(size = 12)Pageable pageable) {
        return new ResponseEntity<>(iMouseService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/mouse/search/{name}")
    public ResponseEntity<Page<Product>> searchMouse(@PageableDefault(size = 12) Pageable pageable, @PathVariable("name") String name) {
        return new ResponseEntity<>(iMouseService.findByName(pageable, name),HttpStatus.OK);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<Product> searchMouse(@PathVariable("id") int id) {
        return new ResponseEntity<>(iProductService.findById(id),HttpStatus.OK);
    }
}
