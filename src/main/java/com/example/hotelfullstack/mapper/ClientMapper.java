package com.example.hotelfullstack.mapper;

import com.example.hotelfullstack.dtos.ClientDTO;
import com.example.hotelfullstack.models.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDto(Client entity);
    Client toClient(ClientDTO entity);
}