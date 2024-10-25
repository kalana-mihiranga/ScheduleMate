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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServiceService {
    private final ServicesRepository servicesRepository;
    private final ObjectMapper objectMapper;


    @Override
    public void createPackage(ServiceDto packages) {
        Optional<Services> packageRepositoryByName = Optional.ofNullable(servicesRepository.findByName(packages.getName()));
        if(packageRepositoryByName.isPresent()){
            throw new CommonException(ResponseCode.DUPLICATE);
        }else {
            Services servicesEntity = objectMapper.convertValue(packages, Services.class);
            servicesRepository.save(servicesEntity);

        }

    }
}
