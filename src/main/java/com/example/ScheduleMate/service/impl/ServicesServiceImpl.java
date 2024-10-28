package com.example.ScheduleMate.service.Impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.ServiceDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.entity.Services;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.repository.ServicesRepository;
import com.example.ScheduleMate.service.ServiceService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServiceService {
    private final ServicesRepository servicesRepository;
    private final ClientRepository clientRepository;
    private final PackagesRepository packagesRepository;

    @Override
    @Transactional
    public void createService(ServiceDto serviceDto) {

        Optional<Client> res = Optional.of(clientRepository.getById(serviceDto.getBusinessId()));

        if (res.isPresent()) {

            List<Packages> existingPackages = new ArrayList<>();
            Services serviceInstance = new Services();

            serviceInstance.setClient(res.get());
            serviceInstance.setName(serviceDto.getName());
            serviceInstance.setDiscountRate(serviceDto.getDiscountRate());
            serviceInstance.setDescription(serviceDto.getDescription());
            serviceInstance.setConditions(serviceDto.getConditions());
            serviceInstance.setServiceFrom(serviceDto.getServiceFrom());
            serviceInstance.setServiceTo(serviceDto.getServiceTo());
            serviceInstance.setAvailability(serviceDto.getAvailability());
            serviceInstance.setImageUrl(serviceDto.getImageUrl());

            for (int i = 0; i < serviceDto.getPackageList().size(); i++) {
                Packages existingPackage = packagesRepository.findById(serviceDto.getPackageList().get(i).getPackageId()).orElse(null);
                if (existingPackage != null) {
                    existingPackages.add(existingPackage);
                }
            }

            serviceInstance.setPackages(existingPackages);
            servicesRepository.save(serviceInstance);

        } else {
            throw new CommonException(ResponseCode.RESOURCE_NOT_FOUND);
        }

    }
}
