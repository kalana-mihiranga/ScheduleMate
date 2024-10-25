package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.service.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<Client> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Client currentUser = (Client) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> allUsers() {
        List <Client> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }
}