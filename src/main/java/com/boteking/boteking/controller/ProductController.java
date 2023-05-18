package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Product;
import com.boteking.boteking.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> productList() {
        return productService.getAll();
    }
    @PostMapping
    public void save(Product product) {
        productService.create(product);
    }
    @PutMapping
    public void update(Product product) {
        if (product.getId() > 0) {
            productService.update(product.getId(), product);
        }
    }
    @DeleteMapping
    public void delete(Product product){
        productService.delete(product.getId());
    }
}