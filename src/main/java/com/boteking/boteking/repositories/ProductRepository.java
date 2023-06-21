package com.boteking.boteking.repositories;

import com.boteking.boteking.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
