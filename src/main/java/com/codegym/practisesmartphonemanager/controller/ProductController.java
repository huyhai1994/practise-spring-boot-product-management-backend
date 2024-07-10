package com.codegym.practisesmartphonemanager.controller;

import com.codegym.practisesmartphonemanager.entity.Product;
import com.codegym.practisesmartphonemanager.service.intefaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping
    @CrossOrigin("*")
    ResponseEntity<Iterable<Product>> getAllProducts() {
        List<Product> products = (List<Product>) productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.save(product);
        System.out.println("hello");
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Product> removeProduct(@PathVariable Long id) {
        Optional<Product> oldProduct = productService.findById(id);
        if (oldProduct.isPresent()) {
            productService.deleteById(id);
            return new ResponseEntity<>(oldProduct.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
