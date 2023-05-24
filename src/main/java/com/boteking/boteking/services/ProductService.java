package com.boteking.boteking.services;

import com.boteking.boteking.entities.Product;
import com.boteking.boteking.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public void update(Product updatedProduct) {
        if (!productRepository.existsById(updatedProduct.getId())) {
            throw new NoSuchElementException("Produto não encontrado");
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
