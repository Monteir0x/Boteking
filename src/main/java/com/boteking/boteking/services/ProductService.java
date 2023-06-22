package com.boteking.boteking.services;

import com.boteking.boteking.entities.Product;
import com.boteking.boteking.repositories.ProductRepository;
import com.boteking.boteking.services.exceptions.DatabaseExceptions;
import com.boteking.boteking.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public void update(Product updatedProduct) {
        if (!productRepository.existsById(updatedProduct.getId())) {
            throw new DatabaseExceptions("Produto não encontrado, criado novo produto");
        }
        Product.builder()
                .id(updatedProduct.getId())
                .name(updatedProduct.getName())
                .price(updatedProduct.getPrice())
                .cost(updatedProduct.getCost())
                .quantity(updatedProduct.getQuantity())
                .build();
        productRepository.save(updatedProduct);
    }

    public void delete(int id) {
        productRepository.deleteById(getById(id).getId());
    }
}
