package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.Notification.BookingNotificationEvent;
import com.example.ScheduleMate.Notification.NotificationService;
import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.EmailDto;
import com.example.ScheduleMate.dto.UserDto;
import com.example.ScheduleMate.dto.ClientDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Role;
import com.example.ScheduleMate.feignClient.EmailInterface;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.service.ClientService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.ClientDtoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final EmailInterface emailInterface;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void createClient(ClientDto client) {

        Optional<Client> res = Optional.ofNullable(clientRepository.findByEmail(client.getEmail()));

        if (res.isPresent()) {
            throw new CommonException(ResponseCode.DUPLICATE);
        } else  {
            Client clientEntity = ClientDtoUtils.CLIENT_DTO_CLIENT_FUNCTION.apply(client);

            if(client.getRole().equals(String.valueOf(Role.CLIENT))) {
                clientEntity.setRole(Role.CLIENT);
            }else if(client.getRole().equals(String.valueOf(Role.BUSINESS))) {
                clientEntity.setRole(Role.BUSINESS);
            }

            String hashedPassword = com.example.ScheduleMate.service.Impl.PasswordUtil.hashPassword(client.getPassword());
            clientEntity.setPassword(hashedPassword);

            clientRepository.save(clientEntity);

            BookingNotificationEvent notificationEvent = new BookingNotificationEvent(
                    "email",
                    "New client created with email: " + client.getEmail(),
                    clientEntity.getRole().toString(),
                    client.getEmail()
            );
            eventPublisher.publishEvent(notificationEvent);
        }

    }

    @Override
    public boolean authenticateClient(UserDto userDto) {
        Optional<Client> clientByEmail = Optional.ofNullable(clientRepository.findByEmail(userDto.getUserName()));

        if (clientByEmail.isPresent()) {
            return com.example.ScheduleMate.service.Impl.PasswordUtil.verifyPassword(userDto.getPassword(), clientByEmail.get().getPassword());
        }

        return false;
    }

    @Override
    public ClientDto findClientByPhoneNumber(String phoneNumber) {
        Optional<Client> clientByPhoneNumber = Optional.ofNullable(clientRepository.findByPhoneNumber(phoneNumber));

        if(clientByPhoneNumber.isPresent()){
            return ClientDtoUtils.CLIENT_CLIENT_DTO_FUNCTION.
                    apply(clientByPhoneNumber.get());
        }else {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }
    }

    @Override
    public List<ClientDto> getAllClients() {
        return  clientRepository.findAll().
                stream().map(e->ClientDtoUtils.CLIENT_CLIENT_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }
}
