package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.ServiceDto;
import com.example.ScheduleMate.dto.ServiceListDto;
import com.example.ScheduleMate.dto.ServicePackageDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Feedback;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.entity.Services;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.repository.FeedbackRepository;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.repository.ServicesRepository;
import com.example.ScheduleMate.service.ServiceService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.ServiceDtoUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServiceService {
    private final ServicesRepository servicesRepository;
    private final ClientRepository clientRepository;
    private final PackagesRepository packagesRepository;
    private final FeedbackRepository feedbackRepository;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public void createService(ServiceDto serviceDto) {

        Optional<Client> existingService = Optional.of(clientRepository.getById(serviceDto.getBusinessId()));

        if (existingService.isPresent()) {

            List<Packages> existingPackages = new ArrayList<>();
            Services serviceInstance = new Services();

            serviceInstance.setClient(existingService.get());
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

    @Override
    public List<ServiceListDto> getServiceListView() {

        List<Services> servicesList = servicesRepository.findAll().stream().toList();

        List<ServiceListDto> serviceListDtos = new ArrayList<>();

        for (Services service : servicesList) {
            ServiceListDto serviceListDto = new ServiceListDto();
            Client client = service.getClient();
            Integer rating = feedbackRepository.findByBusiness(client).getRating();
            serviceListDto.setRating(rating);
            serviceListDto.setId(service.getId());
            serviceListDto.setName(service.getName());
            serviceListDto.setDescription(service.getDescription());
            serviceListDto.setImageUrl(service.getImageUrl());

            serviceListDtos.add(serviceListDto);

        }

        return serviceListDtos;
    }

    @Override
    public ServiceDto getServiceById(Long id) {
        Optional<Services> serviceById = servicesRepository.findById(id);
        if (serviceById.isPresent()) {
            ServiceDto serviceDto = new ServiceDto();
            serviceDto.setId(serviceById.get().getId());
            serviceDto.setName(serviceById.get().getName());
            serviceDto.setDiscountRate(serviceById.get().getDiscountRate());
            serviceDto.setDescription(serviceById.get().getDescription());

            serviceDto.setBusinessId(serviceById.get().getClient().getId());
            serviceDto.setConditions(serviceById.get().getConditions());
            serviceDto.setServiceFrom(serviceById.get().getServiceFrom());
            serviceDto.setServiceTo(serviceById.get().getServiceTo());
            serviceDto.setAvailability(serviceById.get().getAvailability());
            serviceDto.setPackageList(serviceById.get().getPackages().stream()
                    .map(e->new ServicePackageDto(e.getId(),e.getName(),e.getDuration(),e.getPrice())).collect(Collectors.toList()));


            serviceDto.setImageUrl(serviceById.get().getImageUrl());


            return serviceDto;

        } else {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }


    }

    @Override
    public List<ServiceDto> getServiceByBusinessId(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return servicesRepository.findAllByClient(client.get()).stream().
                    map(e -> ServiceDtoUtils.SERVICES_SERVICE_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
        } else {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }


    }


    @Override
    public Page<ServiceDto> getServiceListByBusinessId(Long id, Pageable pageable) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return servicesRepository.findAllByClient(client.get(), pageable)
                    .map(ServiceDtoUtils.SERVICES_SERVICE_DTO_FUNCTION::apply);
        } else {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }
    }

    @Override
    public List<ServiceDto> searchServicesByName(String name) {
        if (name.equals(String.valueOf(""))) {
            return servicesRepository.findAll().stream().map(e -> ServiceDtoUtils.SERVICES_SERVICE_DTO_FUNCTION.apply(e)).collect(Collectors.toList());

        } else {

            return servicesRepository.
                    findAllByNameContainingIgnoreCase(name).stream().map(e -> ServiceDtoUtils.SERVICES_SERVICE_DTO_FUNCTION.apply(e)).collect(Collectors.toList());

        }

    }
}
