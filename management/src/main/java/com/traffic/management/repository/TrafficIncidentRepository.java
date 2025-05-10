package com.traffic.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traffic.management.entity.TrafficIncident;

@Repository
public interface TrafficIncidentRepository extends JpaRepository<TrafficIncident, Long> {
}
