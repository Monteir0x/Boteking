package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Balance;
import com.boteking.boteking.services.BalanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Balance")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public List<Balance> balanceList() {
        return balanceService.getAll();
    }
    @PostMapping
    public void save(@RequestBody Balance balance) {
        balanceService.create(balance);
    }
    @PutMapping
    public void update(@RequestBody Balance balance) {
        if (balance.getId() > 0) {
            balanceService.update(balance.getId(), balance);
        }
    }
    @DeleteMapping
    public void delete(@RequestBody Balance balance){
        balanceService.delete(balance.getId());
    }
}
