package com.boteking.boteking.services;

import com.boteking.boteking.entities.Caderno;
import com.boteking.boteking.repositories.CadernoRepository;
import com.boteking.boteking.services.exceptions.DatabaseExceptions;
import com.boteking.boteking.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .orElseThrow(()-> new ResourceNotFoundException("Caderno não encontrado"));
    }
    public Caderno create(Caderno caderno){
        return cadernoRepository.save(caderno);
    }
    public void update(Caderno updatedCaderno){
        if (!cadernoRepository.existsById(updatedCaderno.getId())){
            throw new DatabaseExceptions("Caderno não encontrado, criado novo caderno");
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
