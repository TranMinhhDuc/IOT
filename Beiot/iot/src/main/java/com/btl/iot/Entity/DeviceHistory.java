package com.btl.iot.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "device")
@Entity
public class DeviceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "device_name")
    private String deviceName;
    private String action;
    private LocalTime actionTime;
    private LocalDate actionDate;

    public void setActionDate() {
        this.actionDate = LocalDate.now();
    }

    public void setActionTime() {
        this.actionTime = LocalTime.now();
    }
}