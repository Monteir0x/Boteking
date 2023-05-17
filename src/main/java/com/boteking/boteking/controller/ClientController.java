package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Client;
import com.boteking.boteking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Client")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    private List<Client> clientList(){
       return clientRepository.findAll();
    }
    @PostMapping
    private void save(@RequestBody Client client){
        clientRepository.save(client);
    }
    @PutMapping
    private void update(@RequestBody Client client){
        if (client.getId() > 0){
            clientRepository.save(client);
        }
    }
    @DeleteMapping
    private void delete(@RequestBody Client client){
        clientRepository.delete(client);
    }
}
