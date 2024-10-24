package com.IotBTl.IOTbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = Math.round(temperature * 10) / 10.0f;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = Math.round(humidity * 10) / 10.0f;
    }

    public float getBright() {
        return bright;
    }

    public void setBright(float bright) {
        this.bright = Math.round(bright * 10) / 10.0f;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate() {
        this.measurementDate = LocalDate.now();
    }

    public LocalTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime() {
        this.measurementTime = LocalTime.now();
    }
}
