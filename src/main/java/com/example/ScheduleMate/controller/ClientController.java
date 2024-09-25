package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.clientDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.ClientService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client")
@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Null>> createClients(@RequestBody clientDto client){
        clientService.createClient(client);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }



}
