package com.example.ScheduleMate.controller;


import com.example.ScheduleMate.dto.ServiceDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.ServiceService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ServiceController {

    private final ServiceService serviceService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Null>> createService(@Valid @RequestBody ServiceDto serviceDto) {
        serviceService.createPackage(serviceDto);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }

    @GetMapping("/list")
    public ResponseEntity<APIResponse<List<ServiceDto>>> listAllServices() {
        List<ServiceDto> services = serviceService.getAllServices();
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, services));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ServiceDto>> getServiceById(@PathVariable Long id) {
        ServiceDto service = serviceService.getServiceById(id);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, service));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<Null>> updateService(@Valid
            @PathVariable Long id,
            @RequestBody ServiceDto serviceDto) {
        serviceService.updateService(id, serviceDto);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Null>> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }



}
