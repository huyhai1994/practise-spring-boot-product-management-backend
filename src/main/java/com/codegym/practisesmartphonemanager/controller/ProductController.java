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

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.save(product);
        System.out.println("hello");
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> oldProduct = productService.findById(id);
        if (oldProduct.isPresent()) {
            Product product = oldProduct.get();
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            product.setColor(updatedProduct.getColor());
            product.setDescription(updatedProduct.getDescription());
            productService.save(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
