package com.traffic.management.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traffic_incidents")
public class TrafficIncident {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String location;
    
    @Enumerated(EnumType.STRING)
    private IncidentType type;
    
    @Enumerated(EnumType.STRING)
    private IncidentSeverity severity;
    
    private LocalDateTime reportedTime;
    
    public enum IncidentType {
        ACCIDENT, CONGESTION, ROADWORK, HAZARD
    }
    
    public enum IncidentSeverity {
        LOW, MEDIUM, HIGH, CRITICAL
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
    
    public IncidentType getType() {
        return type;
    }
    
    public void setType(IncidentType type) {
        this.type = type;
    }
    
    public IncidentSeverity getSeverity() {
        return severity;
    }
    
    public void setSeverity(IncidentSeverity severity) {
        this.severity = severity;
    }
    
    public LocalDateTime getReportedTime() {
        return reportedTime;
    }
    
    public void setReportedTime(LocalDateTime reportedTime) {
        this.reportedTime = reportedTime;
    }
}
