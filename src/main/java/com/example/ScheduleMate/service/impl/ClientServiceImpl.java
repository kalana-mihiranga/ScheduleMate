package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.clientDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Role;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.service.ClientService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.ClientDtoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public void createClient(clientDto client) {


        Client clientEntity = ClientDtoUtils.CLIENT_DTO_CLIENT_FUNCTION.apply(client);
        if(client.getRole().equals(String.valueOf(Role.CLIENT))) {
            clientEntity.setRole(Role.CLIENT);

        }else if(client.getRole().equals(String.valueOf(Role.BUSINESS_OWNER))) {
            clientEntity.setRole(Role.BUSINESS_OWNER);

        }

        clientRepository.save(clientEntity);
    }

    @Override
    public clientDto findClientByPhoneNumber(String phoneNumber) {

        Optional<Client> clientByPhoneNumber = Optional.ofNullable(clientRepository.findByPhoneNumber(phoneNumber));

        if(clientByPhoneNumber.isPresent()){
            return ClientDtoUtils.CLIENT_CLIENT_DTO_FUNCTION.
                    apply(clientByPhoneNumber.get());

        }else {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }

    }

    @Override
    public List<clientDto> getAllClients() {
        return  clientRepository.findAll().
                stream().map(e->ClientDtoUtils.CLIENT_CLIENT_DTO_FUNCTION.apply(e)).collect(Collectors.toList());

    }
}
