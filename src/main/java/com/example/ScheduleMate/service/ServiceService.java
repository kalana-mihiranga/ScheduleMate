package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.ServiceDto;
import com.example.ScheduleMate.dto.ServiceListDto;

import java.util.List;

public interface ServiceService {
    void createService(ServiceDto serviceDto);
   List<ServiceListDto> getServiceListView();

   ServiceDto getServiceById(Long id);
}
