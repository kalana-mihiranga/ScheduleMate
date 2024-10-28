package com.example.ScheduleMate.service.Impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Packages;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.service.PackageService;
import com.example.ScheduleMate.utils.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {

    private final PackagesRepository packagesRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public void createPackage(PackageDto packages) {

        Optional<Client> res = Optional.of(clientRepository.getById(packages.getBusinessId()));

        if (res.isPresent()) {
            Packages packages1 = new Packages();

            packages1.setName(packages.getName());
            packages1.setPrice(packages.getPrice());
            packages1.setDuration(packages.getDuration());
            packages1.setMaximumCount(packages.getMaximumCount());
            packages1.setClient(res.get());

            packagesRepository.save(packages1);
        } else {
            throw new CommonException(ResponseCode.RESOURCE_NOT_FOUND);
        }

    }
}
