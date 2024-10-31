package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.BusinessPackageResponse;
import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.dto.ServiceDto;
import com.example.ScheduleMate.entity.Packages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import java.util.List;

public interface PackageService {
    void createPackage(PackageDto packages);
    List<PackageDto> getBusinessPackages(Long id);
    List<PackageDto> getAllPackages();

    Page<PackageDto> getPackageListByBusinessId(Long id, Pageable pageable);
}
