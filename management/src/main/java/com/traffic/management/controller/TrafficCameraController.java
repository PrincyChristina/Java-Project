package com.traffic.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traffic.management.entity.TrafficCamera;
import com.traffic.management.service.TrafficCameraService;

@RestController
@RequestMapping("/api/cameras")
public class TrafficCameraController {
    
    @Autowired
    private TrafficCameraService trafficCameraService;
    
    @GetMapping
    public List<TrafficCamera> getAllTrafficCameras() {
        return trafficCameraService.getAllTrafficCameras();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TrafficCamera> getTrafficCameraById(@PathVariable Long id) {
        return trafficCameraService.getTrafficCameraById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public TrafficCamera createTrafficCamera(@RequestBody TrafficCamera trafficCamera) {
        return trafficCameraService.saveTrafficCamera(trafficCamera);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TrafficCamera> updateTrafficCamera(@PathVariable Long id, @RequestBody TrafficCamera trafficCamera) {
        return trafficCameraService.getTrafficCameraById(id)
                .map(existingCamera -> {
                    trafficCamera.setId(id);
                    return ResponseEntity.ok(trafficCameraService.saveTrafficCamera(trafficCamera));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrafficCamera(@PathVariable Long id) {
        return trafficCameraService.getTrafficCameraById(id)
                .map(existingCamera -> {
                    trafficCameraService.deleteTrafficCamera(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
