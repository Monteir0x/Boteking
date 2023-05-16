package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Balance;
import com.boteking.boteking.repositories.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Balance")
public class BalanceController {
    @Autowired
    private BalanceRepository balanceRepository;
    @GetMapping
    public List<Balance> balanceList() {
        return balanceRepository.findAll();
    }
    @PostMapping
    public void save(@RequestBody Balance balance) {
        balanceRepository.save(balance);
    }
    @PutMapping
    public void update(@RequestBody Balance balance) {
        if (balance.getId() > 0) {
            balanceRepository.save(balance);
        }
    }
    @DeleteMapping
    public void delete(@RequestBody Balance balance){
        balanceRepository.delete(balance);
    }
}
