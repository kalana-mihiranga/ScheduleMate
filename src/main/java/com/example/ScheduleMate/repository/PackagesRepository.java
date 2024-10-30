package com.example.ScheduleMate.repository;

import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackagesRepository extends JpaRepository<Packages,Long> {

}
