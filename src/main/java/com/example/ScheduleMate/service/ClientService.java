package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.clientDto;
import com.example.ScheduleMate.entity.Client;

import java.util.List;

public interface ClientService {
    void createClient(clientDto client);
    clientDto findClientByPhoneNumber(String phoneNumber)  ;
    List<clientDto> getAllClients();

}
