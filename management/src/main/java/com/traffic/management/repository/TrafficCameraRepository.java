package com.traffic.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traffic.management.entity.TrafficCamera;

@Repository
public interface TrafficCameraRepository extends JpaRepository<TrafficCamera, Long> {
}