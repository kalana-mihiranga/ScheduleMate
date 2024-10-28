package com.example.ScheduleMate.utils.converters;

import com.example.ScheduleMate.dto.ClientDto;
import com.example.ScheduleMate.entity.Client;

import java.util.function.Function;

public class ClientDtoUtils {

    public static final Function<ClientDto, Client> CLIENT_DTO_CLIENT_FUNCTION = clientRequest -> {
        Client client = new Client();
        client.setId(clientRequest.getId());
        client.setEmail(clientRequest.getEmail());
        client.setBusinessName(clientRequest.getBusinessName());
        client.setFirstName(clientRequest.getFirstName());
        client.setLastName(clientRequest.getLastName());
        client.setPhoneNumber(clientRequest.getPhoneNumber());
        return client;
    };

    public static final Function<Client, ClientDto> CLIENT_CLIENT_DTO_FUNCTION = client -> {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setEmail(client.getEmail());
        clientDto.setBusinessName(client.getBusinessName());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        return clientDto;
    };

}