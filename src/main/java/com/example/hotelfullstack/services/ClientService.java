package com.example.hotelfullstack.services;

import com.example.hotelfullstack.exceptions.ResourceNotFoundException;
import com.example.hotelfullstack.models.Client;
import com.example.hotelfullstack.repositories.ClientRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Client updatedClient = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Client")
        );
        updatedClient.setFullName(client.getFullName());
        updatedClient.setPassport(client.getPassport());
        updatedClient.setPhone(client.getPhone());
        return updatedClient;
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Client")
        );
        clientRepository.delete(client);
    }
}
