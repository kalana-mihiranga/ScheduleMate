package com.example.ScheduleMate.utils.converters;

import com.example.ScheduleMate.dto.clientDto;
import com.example.ScheduleMate.entity.Client;

import java.util.function.Function;

public class ClientDtoUtils {
    public static final Function<clientDto, Client> CLIENT_DTO_CLIENT_FUNCTION = clientRequest -> {
        Client client = new Client();
        client.setId(clientRequest.getId());
        client.setEmail(clientRequest.getEmail());
        client.setName(clientRequest.getName());
        client.setHomeAddress(clientRequest.getHomeAddress());
        client.setFirstName(clientRequest.getFirstName());
        client.setLastName(clientRequest.getLastName());
        client.setPhoneNumber(clientRequest.getPhoneNumber());
        client.setDateOfBirth(clientRequest.getDateOfBirth());
        return client;
    };
    public static final Function<Client, clientDto> CLIENT_CLIENT_DTO_FUNCTION = client -> {
        clientDto clientDto = new clientDto();
        clientDto.setId(client.getId());
        clientDto.setEmail(client.getEmail());
        clientDto.setName(client.getName());
        clientDto.setHomeAddress(client.getHomeAddress());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setDateOfBirth(client.getDateOfBirth());
        return clientDto;
    };

}