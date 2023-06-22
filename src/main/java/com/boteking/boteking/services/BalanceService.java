package com.boteking.boteking.services;

import com.boteking.boteking.entities.Balance;
import com.boteking.boteking.repositories.BalanceRepository;
import com.boteking.boteking.services.exceptions.DatabaseExceptions;
import com.boteking.boteking.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {
    private final BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public List<Balance> getAll(){
        return balanceRepository.findAll();
    }

    public Balance getById(int id){
        return balanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Balanço não encontrado"));
    }
    public Balance create(Balance balance){
        return balanceRepository.save(balance);
    }
    public void update(Balance updatedBalance){
        if (!balanceRepository.existsById(updatedBalance.getId())){
            throw new DatabaseExceptions("Balanço não encontrado");
        }
        Balance.builder()
                .id(updatedBalance.getId())
                .client(updatedBalance.getClient())
                .product(updatedBalance.getProduct())
                .build();
        balanceRepository.save(updatedBalance);
    }

    public void delete(int id){
        Balance balance = getById(id);
        balanceRepository.delete(balance);
    }
}