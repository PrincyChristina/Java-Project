package com.traffic.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traffic.management.entity.TrafficSignal;
import com.traffic.management.repository.TrafficSignalRepository;

@Service
public class TrafficSignalService {
    
    @Autowired
    private TrafficSignalRepository trafficSignalRepository;
    
    public List<TrafficSignal> getAllTrafficSignals() {
        return trafficSignalRepository.findAll();
    }
    
    public Optional<TrafficSignal> getTrafficSignalById(Long id) {
        return trafficSignalRepository.findById(id);
    }
    
    public TrafficSignal saveTrafficSignal(TrafficSignal trafficSignal) {
        return trafficSignalRepository.save(trafficSignal);
    }
    
    public void deleteTrafficSignal(Long id) {
        trafficSignalRepository.deleteById(id);
    }
}
