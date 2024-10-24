package com.IotBTl.IOTbe.specication;

import com.IotBTl.IOTbe.entity.ControlDevicesHistory;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeviceSpecification {

    public static Specification<ControlDevicesHistory> findByName(String deviceName) {
        return (root, query, builder) -> builder.like(root.get("deviceName"), "%" + deviceName + "%");
    }

    public static Specification<ControlDevicesHistory> findByDate(LocalDate firstDate, LocalDate lastDate) {
        return (root, query, builder) -> builder.between(root.get("actionDate"), firstDate, lastDate);
    }

    public static Specification<ControlDevicesHistory> findByTime(LocalTime begin, LocalTime end) {
        return (root, query, builder) -> builder.between(root.get("actionTime"), begin, end);
    }
}
