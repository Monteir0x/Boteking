package com.boteking.boteking.services;

import com.boteking.boteking.entities.Client;
import com.boteking.boteking.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
    }
    public Client create(Client client){
        return clientRepository.save(client);
    }
    public Client update(int id, Client updatedClient){
        Client client = getById(id);

        client.setName(client.getName());
        client.setProduct(client.getProduct());

        return clientRepository.save(client);

    }
    public void delete(int id){
        Client client = getById(id);
        clientRepository.delete(client);
    }
}
