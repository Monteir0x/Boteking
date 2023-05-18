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

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(int id){
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
    }
    public Product create(Product product){
        return productRepository.save(product);
    }
    public Product update(int id, Product updatedProduct){
        Product product = getById(id);

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());

        return productRepository.save(product);
    }

    public void delete(int id){
        Product product = getById(id);

        productRepository.delete(product);
    }
}
