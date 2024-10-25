package com.example.ScheduleMate.service.impl;


import com.example.ScheduleMate.configs.exception.CommonException;
import com.example.ScheduleMate.dto.ServiceDto;
import com.example.ScheduleMate.entity.Services;
import com.example.ScheduleMate.repository.ServicesRepository;
import com.example.ScheduleMate.service.ServiceService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServiceService {
    private final ServicesRepository servicesRepository;
    private final ObjectMapper objectMapper;


    @Override
    public void createPackage(ServiceDto serviceDto) {
        Optional<Services> existingService = Optional.ofNullable(servicesRepository.findByName(serviceDto.getName()));
        if (existingService.isPresent()) {
            throw new CommonException(ResponseCode.DUPLICATE);
        } else {
            Services servicesEntity = objectMapper.convertValue(serviceDto, Services.class);
            servicesRepository.save(servicesEntity);
        }
    }

    @Override
    public List<ServiceDto> getAllServices() {
        return servicesRepository.findAll().stream()
                .map(service -> objectMapper.convertValue(service, ServiceDto.class))
                .toList();
    }

    @Override
    public ServiceDto getServiceById(Long id) {
        Services service = servicesRepository.findById(id)
                .orElseThrow(() -> new CommonException(ResponseCode.NOT_FOUND));
        return objectMapper.convertValue(service, ServiceDto.class);
    }

    @Override
    public void updateService(Long id, ServiceDto serviceDto) {
        Services existingService = servicesRepository.findById(id)
                .orElseThrow(() -> new CommonException(ResponseCode.NOT_FOUND));

        existingService.setName(serviceDto.getName());
        existingService.setPrice(serviceDto.getPrice());
        existingService.setDiscountRate(serviceDto.getDiscountRate());
        existingService.setDuration(serviceDto.getDuration());
        existingService.setDescription(serviceDto.getDescription());
        existingService.setConditions(serviceDto.getConditions());
        existingService.setServiceFrom(serviceDto.getServiceFrom());
        existingService.setServiceTo(serviceDto.getServiceTo());
        existingService.setAvailability(serviceDto.getAvailability());
        existingService.setImageUrl(serviceDto.getImageUrl());

        servicesRepository.save(existingService);
    }

    @Override
    public void deleteService(Long id) {
        if (!servicesRepository.existsById(id)) {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }
        servicesRepository.deleteById(id);
    }

}
