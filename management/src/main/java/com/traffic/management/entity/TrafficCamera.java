package com.traffic.management.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traffic_cameras")
public class TrafficCamera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String location;
    
    @Enumerated(EnumType.STRING)
    private CameraStatus status;
    
    @Enumerated(EnumType.STRING)
    private Resolution resolution;
    
    public enum CameraStatus {
        ONLINE, OFFLINE, MAINTENANCE
    }
    
    public enum Resolution {
        HD, FULL_HD, UHD
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public CameraStatus getStatus() {
        return status;
    }
    
    public void setStatus(CameraStatus status) {
        this.status = status;
    }
    
    public Resolution getResolution() {
        return resolution;
    }
    
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }
}

