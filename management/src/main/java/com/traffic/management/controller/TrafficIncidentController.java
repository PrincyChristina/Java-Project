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

import com.traffic.management.entity.TrafficIncident;
import com.traffic.management.service.TrafficIncidentService;

@RestController
@RequestMapping("/api/incidents")
public class TrafficIncidentController {
    
    @Autowired
    private TrafficIncidentService trafficIncidentService;
    
    @GetMapping
    public List<TrafficIncident> getAllTrafficIncidents() {
        return trafficIncidentService.getAllTrafficIncidents();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TrafficIncident> getTrafficIncidentById(@PathVariable Long id) {
        return trafficIncidentService.getTrafficIncidentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public TrafficIncident createTrafficIncident(@RequestBody TrafficIncident trafficIncident) {
        return trafficIncidentService.saveTrafficIncident(trafficIncident);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TrafficIncident> updateTrafficIncident(@PathVariable Long id, @RequestBody TrafficIncident trafficIncident) {
        return trafficIncidentService.getTrafficIncidentById(id)
                .map(existingIncident -> {
                    trafficIncident.setId(id);
                    return ResponseEntity.ok(trafficIncidentService.saveTrafficIncident(trafficIncident));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrafficIncident(@PathVariable Long id) {
        return trafficIncidentService.getTrafficIncidentById(id)
                .map(existingIncident -> {
                    trafficIncidentService.deleteTrafficIncident(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}