package com.boteking.boteking.domain.entities.product;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class Product {
    private final Long id;
    private final String name;
    private final BigDecimal salePrice;
    private final BigDecimal purchasePrice;
    private int quantity;

    public Product(Long id, String name, BigDecimal salePrice, BigDecimal purchasePrice, int quantity) {
        validate(name, salePrice, purchasePrice, quantity);
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    private void validate(String name, BigDecimal salePrice, BigDecimal purchasePrice, int quantity) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (salePrice == null || salePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Sale price must be greater than zero");
        }
        if (purchasePrice == null || purchasePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Purchase price must be greater than zero");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }

    public void addStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.quantity += quantity;
    }

    public void removeStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        this.quantity -= quantity;
    }
}
