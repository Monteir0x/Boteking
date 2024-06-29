package com.boteking.boteking.domain.entities.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.boteking.boteking.domain.entities.customer.Customer;
import com.boteking.boteking.domain.entities.product.Product;
import com.boteking.boteking.domain.shared.PaymentMethod;

import lombok.Getter;

@Getter
public class Order {
    private final Long id;
    private final Customer customer;
    private final List<Product> products;

    private final BigDecimal total;;
    private final LocalDateTime dateTime;
    private final PaymentMethod paymentMethod;

    public Order(Long id, Customer customer, List<Product> products, BigDecimal total, LocalDateTime dateTime,
            PaymentMethod paymentMethod) {
        validate(customer, products, total, dateTime, paymentMethod);
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.total = total;
        this.dateTime = dateTime;
        this.paymentMethod = paymentMethod;
    }

    private void validate(Customer customer, List<Product> products, BigDecimal total, LocalDateTime dateTime,
            PaymentMethod paymentMethod) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Products cannot be null or empty");
        }
        if (total == null || total.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Total must be greater than zero");
        }
        if (dateTime == null) {
            throw new IllegalArgumentException("Date and time cannot be null");
        }
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }
    }

    public void approveCredit() {
        if (this.paymentMethod != PaymentMethod.CREDIT) {
            throw new IllegalArgumentException("Only credit orders can be approved");
        }
    }
}
