package com.IotBTl.IOTbe.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeviceCreationRequest {
    private String DeviceName;
    private String Action;
    private LocalTime ActionTime;
    private LocalDate ActionDate;

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

    public LocalTime getActionTime() {
        return ActionTime;
    }

    public void setActionTime(LocalTime actionTime) {
        ActionTime = actionTime;
    }

    public LocalDate getActionDate() {
        return ActionDate;
    }

    public void setActionDate(LocalDate actionDate) {
        ActionDate = actionDate;
    }
}
