package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.PackageService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
public class PackageController {
    private final PackageService packageService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Null>> createEvent(@RequestBody PackageDto packages) {
        packageService.createPackage(packages);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }
}
