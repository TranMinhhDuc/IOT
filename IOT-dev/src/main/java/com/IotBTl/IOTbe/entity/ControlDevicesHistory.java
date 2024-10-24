package com.IotBTl.IOTbe.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ControlDevicesHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "device_name")
    private String deviceName;
    private String action;
    private LocalTime actionTime;
    private LocalDate actionDate;

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalTime getActionTime() {
        return actionTime;
    }

    public void setActionTime() {
        this.actionTime = LocalTime.now();
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public void setActionDate() {
        this.actionDate = LocalDate.now();
    }
}


