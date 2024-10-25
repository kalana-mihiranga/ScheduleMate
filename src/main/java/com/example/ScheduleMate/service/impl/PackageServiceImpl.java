package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.service.PackageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {

    private final ObjectMapper objectMapper;
    private final PackagesRepository packagesRepository;

    @Override
    public void createPackage(PackageDto packages) {
        Packages packageEntity = objectMapper.convertValue(packages, Packages.class);
        packagesRepository.save(packageEntity);

    }


    @Override
    public PackageDto getPackageById(Long id) {
        Packages pkg = packagesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found with id " + id));
        return objectMapper.convertValue(pkg, PackageDto.class);
    }

    @Override
    public void updatePackage(Long id, PackageDto packageDto) {
        Packages pkg = packagesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found with id " + id));

        pkg.setName(packageDto.getName());
        pkg.setDuration(packageDto.getDuration());
        pkg.setMaximumCount(packageDto.getMaximumCount());
        pkg.setPrice(packageDto.getPrice());

        packagesRepository.save(pkg);
    }

    @Override
    public void deletePackage(Long id) {
        if (!packagesRepository.existsById(id)) {
            throw new RuntimeException("Package not found with id " + id);
        }
        packagesRepository.deleteById(id);
    }
}
