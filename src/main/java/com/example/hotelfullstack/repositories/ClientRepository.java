package com.example.hotelfullstack.repositories;

import com.example.hotelfullstack.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
