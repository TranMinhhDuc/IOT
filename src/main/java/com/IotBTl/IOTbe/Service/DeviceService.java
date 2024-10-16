package com.IotBTl.IOTbe.Service;

import com.IotBTl.IOTbe.dto.request.DeviceCreationRequest;
import com.IotBTl.IOTbe.entity.ControllDevicesHistory;
import com.IotBTl.IOTbe.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public ControllDevicesHistory createDeviceHistory(DeviceCreationRequest actDeviceRequest) {
        ControllDevicesHistory newControllDevice = new ControllDevicesHistory();
        newControllDevice.setDeviceName(actDeviceRequest.getDeviceName());
        newControllDevice.setAction(actDeviceRequest.getAction());
        newControllDevice.setActionTime(actDeviceRequest.getActionTime());
        newControllDevice.setActionDate(actDeviceRequest.getActionDate());

        return deviceRepository.save(newControllDevice);
    }

    public Page<ControllDevicesHistory> getDeviceHistory(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return deviceRepository.findAllByOrderByActionDateDescActionTimeDesc(pageable);
    }
}
