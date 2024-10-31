package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.service.PackageService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.PackageDtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {

    private final PackagesRepository packagesRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public void createPackage(PackageDto packages) {

        Optional<Client> client = Optional.of(clientRepository.getById(packages.getBusinessId()));

        if (client.isPresent()) {
            Packages packagesComponent = new Packages();

            packagesComponent.setName(packages.getName());
            packagesComponent.setPrice(packages.getPrice());
            packagesComponent.setDuration(packages.getDuration());
            packagesComponent.setMaximumCount(packages.getMaximumCount());
            packagesComponent.setStatus(Boolean.TRUE);


            packagesComponent.setClient(client.get());

            packagesRepository.save(packagesComponent);
        } else {
            throw new CommonException(ResponseCode.RESOURCE_NOT_FOUND);
        }

    }

    @Override
    public List<PackageDto> getBusinessPackages(Long id) {

        Optional<Client> clientResult = Optional.of(clientRepository.getById(id));

        if (clientResult.isPresent()) {

          return   packagesRepository.getAllByClient(clientResult.get()).stream().map(e->PackageDtoUtils.PACKAGES_PACKAGE_DTO_FUNCTION.apply(e)).collect(Collectors.toList());



        } else {
            return null;
        }
    }
    
    public List<PackageDto> getAllPackages() {
      return packagesRepository.findAll().stream().
              map(e -> PackageDtoUtils.PACKAGES_PACKAGE_DTO_FUNCTION.apply(e)).collect(Collectors.toList());

    }
}
