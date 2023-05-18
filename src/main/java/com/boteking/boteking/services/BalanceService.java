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
    public Balance update(int id, Balance updatedBalance){
        Balance balance = getById(id);

        balance.setProduct(updatedBalance.getProduct());
        balance.setClient(updatedBalance.getClient());

        return balanceRepository.save(balance);
    }

    public void delete(int id){
        Balance balance = getById(id);
        balanceRepository.delete(balance);
    }
}
