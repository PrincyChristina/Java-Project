package com.traffic.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traffic.management.entity.TrafficIncident;
import com.traffic.management.repository.TrafficIncidentRepository;

@Service
public class TrafficIncidentService {
    
    @Autowired
    private TrafficIncidentRepository trafficIncidentRepository;
    
    public List<TrafficIncident> getAllTrafficIncidents() {
        return trafficIncidentRepository.findAll();
    }
    
    public Optional<TrafficIncident> getTrafficIncidentById(Long id) {
        return trafficIncidentRepository.findById(id);
    }
    
    public TrafficIncident saveTrafficIncident(TrafficIncident trafficIncident) {
        return trafficIncidentRepository.save(trafficIncident);
    }
    
    public void deleteTrafficIncident(Long id) {
        trafficIncidentRepository.deleteById(id);
    }
}
