package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Product;
import com.boteking.boteking.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Product> productList() {
        return productRepository.findAll();
    }
    @PostMapping
    public void save(Product product) {
        productRepository.save(product);
    }
    @PutMapping
    public void update(Product product) {
        if (product.getId() > 0) {
            productRepository.save(product);
        }
    }
    @DeleteMapping
    public void delete(Product product){
        productRepository.delete(product);
    }
}