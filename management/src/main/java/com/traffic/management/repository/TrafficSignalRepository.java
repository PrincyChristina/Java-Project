package com.traffic.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traffic.management.entity.TrafficSignal;

@Repository
public interface TrafficSignalRepository extends JpaRepository<TrafficSignal, Long> {
}