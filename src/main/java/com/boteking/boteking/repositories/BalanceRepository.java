package com.boteking.boteking.repositories;

import com.boteking.boteking.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance,Integer> {
}
