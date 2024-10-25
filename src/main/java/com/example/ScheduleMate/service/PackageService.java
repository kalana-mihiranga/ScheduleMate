package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.PackageDto;

public interface PackageService {
    void createPackage(PackageDto packages);

    PackageDto getPackageById(Long id);

    void updatePackage(Long id, PackageDto packageDto);

    void deletePackage(Long id);
}
