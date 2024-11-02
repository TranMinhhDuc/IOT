package com.IotBTl.IOTbe.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeasurementHistoryRequest {

    private float temperature;
    private float humidity;
    private float bright;
    private LocalDate measurementDate;
    private LocalTime measurementTime;

    public float getTemperature() {
        return temperature; 
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getBright() {
        return bright;
    }

    public void setBright(float bright) {
        this.bright = bright;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDate measurementDate) {
        this.measurementDate = measurementDate;
    }

    public void setMeasurementDate() {
        this.measurementDate = LocalDate.now();
    }

    public LocalTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalTime measurementTime) {
        this.measurementTime = measurementTime;
    }

    public void setMeasurementTime() {
        this.measurementTime = LocalTime.now();
    }
}
