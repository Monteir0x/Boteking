package com.boteking.boteking.domain.entities.customer;

import lombok.Getter;

@Getter
public class Customer {
    private final Long id;
    private final String name;
    private final String table;
    private final boolean creditApproved;

    public Customer(Long id, String name, String table, boolean creditApproved) {
        validate(name, table);
        this.id = id;
        this.name = name;
        this.table = table;
        this.creditApproved = creditApproved;
    }

    private void validate(String name, String table) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("Customer table cannot be empty");
        }
    }
}
