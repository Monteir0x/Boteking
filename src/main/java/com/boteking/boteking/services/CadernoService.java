package com.boteking.boteking.services;

import com.boteking.boteking.entities.Caderno;
import com.boteking.boteking.repositories.CadernoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CadernoService {
    private final CadernoRepository cadernoRepository;

    public CadernoService(CadernoRepository cadernoRepository) {
        this.cadernoRepository = cadernoRepository;
    }
    public List<Caderno> getAll(){
        return cadernoRepository.findAll();
    }
    public Caderno getById(int id){
        return cadernoRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Caderno não encontrado"));
    }
    public Caderno create(Caderno caderno){
        return cadernoRepository.save(caderno);
    }
    public void update(Caderno updatedCaderno){
        if (!cadernoRepository.existsById(updatedCaderno.getId())){
            throw new NoSuchElementException("Caderno não encontrado");
        }
        Caderno.builder()
                .id(updatedCaderno.getId())
                .createdAt(updatedCaderno.getCreatedAt())
                .updatedAt(updatedCaderno.getUpdatedAt())
                .status(updatedCaderno.getStatus())
                .cliente(updatedCaderno.getCliente())
                .build();
        cadernoRepository.save(updatedCaderno);
    }
    public void delete(int id){
        Caderno caderno = getById(id);
        cadernoRepository.delete(caderno);
    }
}
