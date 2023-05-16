package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Caderno;
import com.boteking.boteking.repositories.CadernoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Caderno")
public class CadernoController {
    @Autowired
    private CadernoRepository cadernoRepository;

    @GetMapping
    public List<Caderno> cadernoList(){
       return cadernoRepository.findAll();
    }
    @PostMapping
    public void save(@RequestBody Caderno caderno){
        cadernoRepository.save(caderno);
    }
    @PutMapping
    public void update(@RequestBody Caderno caderno){
        if (caderno.getId() > 0){
            cadernoRepository.save(caderno);
        }
    }
    @DeleteMapping
    public void delete(@RequestBody Caderno caderno){
        cadernoRepository.delete(caderno);
    }
}

