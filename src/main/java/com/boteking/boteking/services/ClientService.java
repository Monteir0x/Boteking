package com.boteking.boteking.services;

import com.boteking.boteking.entities.Client;
import com.boteking.boteking.repositories.ClientRepository;
import com.boteking.boteking.services.exceptions.DatabaseExceptions;
import com.boteking.boteking.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    public Client getById(int id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }
    public Client create(Client client){
        return clientRepository.save(client);
    }
    public void update(Client updatedClient){
        if (!clientRepository.existsById(updatedClient.getId())){
            throw new DatabaseExceptions("Cliente não encontrado, criado novo cliente");
        }
        Client.builder()
                .id(updatedClient.getId())
                .name(updatedClient.getName())
                .products(updatedClient.getProducts())
                .build();
        clientRepository.save(updatedClient);
    }
    public void delete(int id){
        Client client = getById(id);
        clientRepository.delete(client);
    }
}
