package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Balance;
import com.boteking.boteking.services.BalanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/balance")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public ResponseEntity<List<Balance>> balanceList() {
        return ResponseEntity.ok(balanceService.getAll());
    }
    @PostMapping
    public ResponseEntity<Balance> save(@RequestBody Balance balance) {
        return ResponseEntity.status(HttpStatus.CREATED).body(balanceService.create(balance));
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Balance balance) {
            balanceService.update(balance);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        balanceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
