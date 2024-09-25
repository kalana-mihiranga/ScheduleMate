package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.dto.clientDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.service.ClientService;
import com.example.ScheduleMate.utils.converters.ClientDtoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public void createClient(clientDto client) {
        Client clientEntity = ClientDtoUtils.CLIENT_DTO_CLIENT_FUNCTION.apply(client);
        clientRepository.save(clientEntity);
    }
}
