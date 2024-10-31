package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.BusinessPackageResponse;
import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.service.PackageService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
public class PackageController {
    private final PackageService packageService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<?>> createEvent(@RequestBody PackageDto packages) {
        packageService.createPackage(packages);

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, packages));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<APIResponse< List<PackageDto> >> getPackages(@PathVariable Long id) {

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, packageService.getBusinessPackages(id)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse<List<PackageDto>>> getAllPackages() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, packageService.getAllPackages()));
    }
}
