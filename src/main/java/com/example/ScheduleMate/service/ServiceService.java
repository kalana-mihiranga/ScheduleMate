package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.ServiceDto;

import java.util.List;

public interface ServiceService {
    void createPackage(ServiceDto serviceDto);

    List<ServiceDto> getAllServices();

    ServiceDto getServiceById(Long id);

    void updateService(Long id, ServiceDto serviceDto);

    void deleteService(Long id);
}
