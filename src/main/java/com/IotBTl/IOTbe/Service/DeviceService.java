package com.IotBTl.IOTbe.Service;

import com.IotBTl.IOTbe.dto.request.DeviceCreationRequest;
import com.IotBTl.IOTbe.entity.ControlDevicesHistory;
import com.IotBTl.IOTbe.repository.DeviceRepository;
import com.IotBTl.IOTbe.specication.DeviceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public ControlDevicesHistory createDeviceHistory(DeviceCreationRequest actDeviceRequest) {
        ControlDevicesHistory newControlDevice = new ControlDevicesHistory();
        newControlDevice.setDeviceName(actDeviceRequest.getDeviceName());
        newControlDevice.setAction(actDeviceRequest.getAction());
        newControlDevice.setActionDate();
        newControlDevice.setActionTime();

        return deviceRepository.save(newControlDevice);
    }

    public Page<ControlDevicesHistory> getDeviceHistory(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return deviceRepository.findAll(pageable);
    }

    public Page<ControlDevicesHistory> findDeviceHistoryByName(String deviceName, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10,
                Sort.by(Sort.Order.desc("actionDate"), Sort.Order.desc("actionTime")));
        Specification<ControlDevicesHistory> spec = Specification
                .where(DeviceSpecification.findByName(deviceName));
        return deviceRepository.findAll(spec, pageable);
    }

    public Page<ControlDevicesHistory> findDeviceHistoryByDate(LocalDate firstDate, LocalDate lastDate, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return deviceRepository.findDeviceHistoryByDate(firstDate, lastDate, pageable);
    }

    public Page<ControlDevicesHistory> findDeviceHistoryByNameAndDate(String deviceName, LocalDate firstDate, LocalDate lastDate, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return deviceRepository.findDeviceHistoryByNameAndDate(deviceName, firstDate, lastDate, pageable);
    }

    public Page<ControlDevicesHistory> findDeviceHistoryByDateAndTime(LocalDate firstDate, LocalDate lastDate, LocalTime begin, LocalTime end, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return deviceRepository.findDeviceHistoryByDateAndTime(firstDate, lastDate, begin, end, pageable);
    }

    public Page<ControlDevicesHistory> findDevicesByAll(String deviceName, LocalDate firstDate, LocalDate lastDate, LocalTime begin, LocalTime end, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return deviceRepository.findDevicesByAll(deviceName, firstDate, lastDate, begin, end, pageable);
    }
}
