package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.UserDto;
import com.example.ScheduleMate.dto.ClientDto;

import java.util.List;

public interface ClientService {
    void createClient(ClientDto client);
    boolean authenticateClient(UserDto userDto);
    ClientDto findClientByPhoneNumber(String phoneNumber)  ;
    List<ClientDto> getAllClients();
}
