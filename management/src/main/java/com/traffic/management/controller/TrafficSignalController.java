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

import com.traffic.management.entity.TrafficSignal;
import com.traffic.management.service.TrafficSignalService;

@RestController
@RequestMapping("/api/signals")
public class TrafficSignalController {
    
    @Autowired
    private TrafficSignalService trafficSignalService;
    
    @GetMapping
    public List<TrafficSignal> getAllTrafficSignals() {
        return trafficSignalService.getAllTrafficSignals();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TrafficSignal> getTrafficSignalById(@PathVariable Long id) {
        return trafficSignalService.getTrafficSignalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public TrafficSignal createTrafficSignal(@RequestBody TrafficSignal trafficSignal) {
        return trafficSignalService.saveTrafficSignal(trafficSignal);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TrafficSignal> updateTrafficSignal(@PathVariable Long id, @RequestBody TrafficSignal trafficSignal) {
        return trafficSignalService.getTrafficSignalById(id)
                .map(existingSignal -> {
                    trafficSignal.setId(id);
                    return ResponseEntity.ok(trafficSignalService.saveTrafficSignal(trafficSignal));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrafficSignal(@PathVariable Long id) {
        return trafficSignalService.getTrafficSignalById(id)
                .map(existingSignal -> {
                    trafficSignalService.deleteTrafficSignal(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
