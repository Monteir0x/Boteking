package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Client;
import com.boteking.boteking.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    private ResponseEntity<List<Client>> clientList(){
       return ResponseEntity.ok(clientService.getAll());
    }
    @PostMapping
    private ResponseEntity<Client> save(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
    }
    @PutMapping
    private ResponseEntity<Void> update(@RequestBody Client client){
        clientService.update(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
