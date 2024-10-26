package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.PackageService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PackageController {
    private final PackageService packageService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Null>> createEvent(@Valid @RequestBody PackageDto packages) {

        packageService.createPackage(packages);

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }


    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<PackageDto>> getPackageById(@PathVariable Long id) {
        PackageDto packageDto = packageService.getPackageById(id);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, packageDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<Null>> updatePackage(@Valid
            @PathVariable Long id,
            @RequestBody PackageDto packageDto) {
        packageService.updatePackage(id, packageDto);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Null>> deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }
}
