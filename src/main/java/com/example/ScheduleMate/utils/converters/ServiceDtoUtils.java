package com.example.ScheduleMate.utils.converters;

import com.example.ScheduleMate.dto.ServiceDto;
import com.example.ScheduleMate.entity.Services;

import java.util.function.Function;

public class ServiceDtoUtils {
    public static final Function<ServiceDto, Services> SERVICE_DTO_SERVICES_FUNCTION = serviceDto -> {
        Services services = new Services();
        services.setId(serviceDto.getId());
        services.setName(serviceDto.getName());
        services.setDiscountRate(serviceDto.getDiscountRate());
        services.setDescription(serviceDto.getDescription());
        services.setConditions(serviceDto.getConditions());
        services.setServiceFrom(serviceDto.getServiceFrom());
        services.setServiceTo(serviceDto.getServiceTo());
        services.setAvailability(serviceDto.getAvailability());
        services.setImageUrl(serviceDto.getImageUrl());
        // Note: Handle the packageList conversion if necessary
        return services;
    };

    public static final Function<Services, ServiceDto> SERVICES_SERVICE_DTO_FUNCTION = services -> {
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setId(services.getId());
        serviceDto.setName(services.getName());
        serviceDto.setDiscountRate(services.getDiscountRate());
        serviceDto.setDescription(services.getDescription());
        serviceDto.setConditions(services.getConditions());
        serviceDto.setServiceFrom(services.getServiceFrom());
        serviceDto.setServiceTo(services.getServiceTo());
        serviceDto.setAvailability(services.getAvailability());
        serviceDto.setImageUrl(services.getImageUrl());
        // Note: Handle the packages conversion if necessary
        return serviceDto;
    };


}
