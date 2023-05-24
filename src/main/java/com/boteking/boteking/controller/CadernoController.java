package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Caderno;
import com.boteking.boteking.services.CadernoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/cardeno")
public class CadernoController {

    private final CadernoService cadernoService;

    public CadernoController(CadernoService cadernoService) {
        this.cadernoService = cadernoService;
    }

    @GetMapping
    public ResponseEntity<List<Caderno>> cadernoList(){
       return ResponseEntity.ok(cadernoService.getAll());
    }
    @PostMapping
    public ResponseEntity<Caderno> save(@RequestBody Caderno caderno){
       return ResponseEntity.status(HttpStatus.CREATED).body(cadernoService.create(caderno));
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Caderno caderno){
            cadernoService.update(caderno);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        cadernoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

