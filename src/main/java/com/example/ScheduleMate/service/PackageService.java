package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.PackageDto;

import java.util.List;

public interface PackageService {
    void createPackage(PackageDto packages);
    List<PackageDto> getAllPackages();
}
