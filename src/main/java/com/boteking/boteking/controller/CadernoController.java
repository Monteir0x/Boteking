package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Caderno;
import com.boteking.boteking.services.CadernoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Caderno")
public class CadernoController {

    private final CadernoService cadernoService;

    public CadernoController(CadernoService cadernoService) {
        this.cadernoService = cadernoService;
    }

    @GetMapping
    public List<Caderno> cadernoList(){
       return cadernoService.getAll();
    }
    @PostMapping
    public void save(@RequestBody Caderno caderno){
        cadernoService.create(caderno);
    }
    @PutMapping
    public void update(@RequestBody Caderno caderno){
        if (caderno.getId() > 0){
            cadernoService.update(caderno.getId(), caderno);
        }
    }
    @DeleteMapping
    public void delete(@RequestBody Caderno caderno){
        cadernoService.delete(caderno.getId());
    }
}

