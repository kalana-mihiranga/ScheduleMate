package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.dto.BusinessPackageResponse;
import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface PackagesRepository extends JpaRepository<Packages,Long> {

    List<Packages> getAllByClient(Client client);

}
