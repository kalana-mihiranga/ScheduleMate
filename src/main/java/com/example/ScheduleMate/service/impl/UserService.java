package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final ClientRepository userRepository;

    public UserService(ClientRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Client> allUsers() {
        List<Client> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}