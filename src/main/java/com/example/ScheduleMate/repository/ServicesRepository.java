package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Long> {
    Services findByName(String name);
    List<Services> findAllByClient(Client client);

    Page<Services> findAllByClient(Client client, Pageable pageable);

}
