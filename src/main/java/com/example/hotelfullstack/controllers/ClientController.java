package com.example.hotelfullstack.controllers;

import com.example.hotelfullstack.dtos.ClientDTO;
import com.example.hotelfullstack.mapper.ClientMapper;
import com.example.hotelfullstack.models.Client;
import com.example.hotelfullstack.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.createClient(clientMapper.toClient(clientDTO));
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) {
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
