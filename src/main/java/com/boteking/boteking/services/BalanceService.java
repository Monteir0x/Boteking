package com.boteking.boteking.services;

import com.boteking.boteking.entities.Balance;
import com.boteking.boteking.repositories.BalanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
                .orElseThrow(() -> new NoSuchElementException("Balanço não encontrado"));
    }
    public Balance create(Balance balance){
        return balanceRepository.save(balance);
    }
    public void update(Balance updatedBalance){
        if (!balanceRepository.existsById(updatedBalance.getId())){
            throw new NoSuchElementException("Balanço não encontrado");
        }
        Balance balance = new Balance(
                updatedBalance.getId(),
                updatedBalance.getClient(),
                updatedBalance.getProduct());
    }

    public void delete(int id){
        Balance balance = getById(id);
        balanceRepository.delete(balance);
    }
}
