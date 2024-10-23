package com.IotBTl.IOTbe.specication;

import com.IotBTl.IOTbe.entity.ControlDevicesHistory;
import org.springframework.data.jpa.domain.Specification;

public class DeviceSpecification {

    public static Specification<ControlDevicesHistory> findByName(String deviceName) {
        return (root, query, builder) -> builder.like(root.get("deviceName"), "%" + deviceName + "%");
    }
}
