package com.traffic.management.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traffic_signals")
public class TrafficSignal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String location;
    
    @Enumerated(EnumType.STRING)
    private SignalStatus status;
    
    private LocalDate installationDate;
    
    public enum SignalStatus {
        OPERATIONAL, MAINTENANCE, FAULTY
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
    
    public SignalStatus getStatus() {
        return status;
    }
    
    public void setStatus(SignalStatus status) {
        this.status = status;
    }
    
    public LocalDate getInstallationDate() {
        return installationDate;
    }
    
    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }
}
