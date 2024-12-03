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
@Table(name = "measurement")
@Entity
public class MeasurementHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float temperature;
    private float humidity;
    private float bright;
    private LocalDate measurementDate;
    private LocalTime measurementTime;

    public void setMeasurementDate() {
        this.measurementDate = LocalDate.now();
    }

    public void setMeasurementTime() {
        this.measurementTime = LocalTime.now();
    }
}
