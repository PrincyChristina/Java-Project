package com.traffic.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traffic.management.entity.TrafficCamera;
import com.traffic.management.repository.TrafficCameraRepository;

@Service
public class TrafficCameraService {
    
    @Autowired
    private TrafficCameraRepository trafficCameraRepository;
    
    public List<TrafficCamera> getAllTrafficCameras() {
        return trafficCameraRepository.findAll();
    }
    
    public Optional<TrafficCamera> getTrafficCameraById(Long id) {
        return trafficCameraRepository.findById(id);
    }
    
    public TrafficCamera saveTrafficCamera(TrafficCamera trafficCamera) {
        return trafficCameraRepository.save(trafficCamera);
    }
    
    public void deleteTrafficCamera(Long id) {
        trafficCameraRepository.deleteById(id);
    }
}