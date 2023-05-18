package com.boteking.boteking.controller;

import com.boteking.boteking.entities.Client;
import com.boteking.boteking.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    private List<Client> clientList(){
       return clientService.getAll();
    }
    @PostMapping
    private void save(@RequestBody Client client){
        clientService.create(client);
    }
    @PutMapping
    private void update(@RequestBody Client client){
        if (client.getId() > 0){
            clientService.update(client.getId(), client);
        }
    }
    @DeleteMapping
    private void delete(@RequestBody Client client){
        clientService.delete(client.getId());
    }
}
