package com.codegym.controller;


import com.codegym.model.bill.SearchBrandDTO;
import com.codegym.model.product.*;
import com.codegym.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired  
    private IProductService iProductService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        return new ResponseEntity<>(iProductService.findById(id),HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @GetMapping("/warehouse/{id}/{quantity}")
    public ResponseEntity<?> wareHouse(@PathVariable("id") int id,@PathVariable("quantity") int quantity) {
        Product product = iProductService.findById(id);
        product.setQuantity(product.getQuantity() + quantity);
        iProductService.save(product);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @RequestMapping
    public ResponseEntity<Page<Product>> getAll(@PageableDefault(size = 6)Pageable pageable) {
        return new ResponseEntity<>( iProductService.findAll(pageable),HttpStatus.OK);
    }
    @RequestMapping("/hot")
    public ResponseEntity<Page<Product>> hotProduct(@PageableDefault(size = 4)Pageable pageable) {
        return new ResponseEntity<>( iProductService.hotProduct(pageable),HttpStatus.OK);
    }
    @GetMapping("/all/{name}")
    public ResponseEntity<Page<Product>> findAllByName(@PageableDefault(size = 6)Pageable pageable,@PathVariable("name") String name) {
        return new ResponseEntity<>( iProductService.findAllByName(pageable,name),HttpStatus.OK);
    }

    @PostMapping("/searchBrand")
    public ResponseEntity<?> findByBrand(@PageableDefault(size = 6)Pageable pageable,@RequestBody SearchBrandDTO brand) {
        if (brand.getId() == 7) {
            return new ResponseEntity<>(iProductService.findAllByBrand(brand.getBrand(),pageable),HttpStatus.OK);
        }
        return new ResponseEntity<>(iProductService.findAllByBrandAndCategory(brand.getBrand(), brand.getId(),pageable),HttpStatus.OK);
    }

    @GetMapping("/searchPrice/{price}/{oldPrice}/{categoryId}")
    public ResponseEntity<Page<Product>> findByBrand(@PageableDefault(size = 6)Pageable pageable,@PathVariable("price") Double price,@PathVariable("oldPrice") Double oldPrice,@PathVariable("categoryId") Integer categoryId) {
        if (categoryId == 7) {
            return new ResponseEntity<>( iProductService.findAllByIsDeleteFalseAndPriceBetween(price,oldPrice,pageable),HttpStatus.OK);
        } else {
            return new ResponseEntity<>( iProductService.findAllByIsDeleteFalseAndPriceBetweenAndCategory_Id(price,oldPrice,categoryId,pageable),HttpStatus.OK);

        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Product>> findAllByCategory(@PageableDefault(size = 6)Pageable pageable,@PathVariable("id") int  id) {
        return new ResponseEntity<>( iProductService.findByCategory(pageable,id),HttpStatus.OK);
    }
    @PostMapping("/pcgaming/cpu")
    public ResponseEntity<Page<Product>> findAllByCategoryAndCpu(@PageableDefault(size = 6)Pageable pageable,@RequestBody String[] cpu) {
        return new ResponseEntity<>( iProductService.findAllByIsDeleteFalseAndCpuAndCategory_Id(cpu,2,pageable),HttpStatus.OK);
    }
    @GetMapping("/category/{id}/{name}")
    public ResponseEntity<Page<Product>> findAllByCategoryAndName(@PageableDefault(size = 6)Pageable pageable,@PathVariable("id") int  id,@PathVariable("name") String name) {
        return new ResponseEntity<>( iProductService.findByCategoryAndName(pageable,id,name),HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @PostMapping("/PC")
    public ResponseEntity<?> createPC(@Valid @RequestBody PC pc, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_GATEWAY);
        }
        Product product = new Product(pc.getName(),pc.getPrice(), pc.getOldPrice(), pc.getImage(),pc.getCpu(),pc.getMainboard(), pc.getRam(), pc.getSsd(), pc.getVga(), pc.getPsu(), pc.getCases(),pc.getCategory());

        if (pc.getId() != null) {
            product.setId(pc.getId());
            Product product2 = iProductService.findById(pc.getId());
            product.setQuantity(product2.getQuantity());
        }
        iProductService.save(product);

        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @PostMapping("/Chair")
    public ResponseEntity<?> createChair(@Valid @RequestBody Chair chair, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_GATEWAY);
        }
        Product product = new Product(chair.getName(),chair.getPrice(), chair.getOldPrice(), chair.getImage(),chair.getMaterial(),chair.getKneelings(), chair.getModel(), chair.getBrand(), chair.getBackrest(),chair.getCategory());
        product.setLocalBrand(chair.getLocalBrand());
        if (chair.getId() != null) {
            product.setId(chair.getId());
            Product product2 = iProductService.findById(chair.getId());
            product.setQuantity(product2.getQuantity());
        }
        iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @PostMapping("/Keyboard")
    public ResponseEntity<?> createKeyboard(@Valid @RequestBody Keyboard keyboard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_GATEWAY);
        }
        Product product = new Product(keyboard.getName(),keyboard.getPrice(), keyboard.getOldPrice(), keyboard.getImage(),keyboard.getKeyboard(),keyboard.getConnect(), keyboard.getKeycap(), keyboard.getswitchKey(), keyboard.getReliability(),keyboard.getCompatible(), keyboard.getCategory());
        if (keyboard.getId() != null) {
            product.setId(keyboard.getId());
                Product product2 = iProductService.findById(keyboard.getId());
                product.setQuantity(product2.getQuantity());
        }
        product.setLocalBrand(keyboard.getLocalBrand());
        iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @PostMapping("/Laptop")
    public ResponseEntity<?> createlaptop(@Valid @RequestBody Laptop laptop, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_GATEWAY);
        }
        Product product = new Product(laptop.getName(),laptop.getPrice(), laptop.getOldPrice(), laptop.getImage(),laptop.getCpu(),laptop.getRam(), laptop.getVga(), laptop.getHardDrive(), laptop.getMonitor(),laptop.getPin(),laptop.getColor(),laptop.getWeight(),laptop.getOs(), laptop.getCategory());
        if (iProductService.existsById(laptop.getId())) {
            Product product2 = iProductService.findById(laptop.getId());
            product.setQuantity(product2.getQuantity());
        }
        product.setLocalBrand(laptop.getLocalBrand());
        if (laptop.getId() != null) {
            Product product2 = iProductService.findById(laptop.getId());
            product.setQuantity(product2.getQuantity());
            product.setId(laptop.getId());
        }
        iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @PostMapping("/Monitor")
    public ResponseEntity<?> createMonitor(@Valid @RequestBody Monitor monitor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_GATEWAY);
        }
        Product product = new Product(monitor.getId(),monitor.getName(),monitor.getPrice(), monitor.getOldPrice(), monitor.getImage(),monitor.getScreenSize(),monitor.getResolution(), monitor.getScanFrequency(), monitor.getAspectRatio(), monitor.getConnector(),monitor.getPanels(), monitor.getCategory());
        if (monitor.getId() != null) {
            Product product2 = iProductService.findById(monitor.getId());
            product.setQuantity(product2.getQuantity());
            product.setId(monitor.getId());
        }

        product.setLocalBrand(monitor.getLocalBrand());
        iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
    @PostMapping("/Mouse")
    public ResponseEntity<?> createMouse(@Valid @RequestBody Mouse mouse, BindingResult bindingResult) {
        System.out.println(mouse);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_GATEWAY);
        }
        Product product = new Product(mouse.getId(),mouse.getName(),mouse.getPrice(), mouse.getOldPrice(), mouse.getImage(),mouse.getConnect(),mouse.getReliability(), mouse.getCompatible(), mouse.getSensor(), mouse.getDpi(),mouse.getWeight(),mouse.getOs(), mouse.getCategory());
        if (mouse.getId() != null) {
            Product product2 = iProductService.findById(mouse.getId());
            product.setQuantity(product2.getQuantity());
            product.setId(mouse.getId());
        }
        product.setLocalBrand(mouse.getLocalBrand());
        iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
       Product product = iProductService.findById(id);
       product.setDelete(true);
       iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CONTINUE);
    }
}
