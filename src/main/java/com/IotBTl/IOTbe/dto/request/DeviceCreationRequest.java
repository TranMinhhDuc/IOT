package com.IotBTl.IOTbe.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeviceCreationRequest {
    private String DeviceName;
    private String Action;


    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }
}
