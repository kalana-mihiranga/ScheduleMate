package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.clientDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.ClientService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/client")
@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<APIResponse<Null>> createClients(@RequestBody clientDto client){
        clientService.createClient(client);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }
    @GetMapping("/all/clients")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<APIResponse<List<clientDto>>> createClients(){
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,clientService.getAllClients()));
    }
    @GetMapping("/{phnNumber}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<APIResponse<clientDto>> createClients(@PathVariable("phnNumber") String phnNumber){
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,clientService.findClientByPhoneNumber(phnNumber)));
    }


}
