package com.example.ScheduleMate.service.Impl;

import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.service.PackageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {

    private final ObjectMapper objectMapper;
    private final PackagesRepository packagesRepository;

    @Override
    public void createPackage(PackageDto packages) {
        Packages packagesEntity = objectMapper.convertValue(packages, Packages.class);
        packagesRepository.save(packagesEntity);

    }
}
